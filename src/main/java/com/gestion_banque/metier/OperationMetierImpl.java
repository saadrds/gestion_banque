package com.gestion_banque.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion_banque.dao.CompteRespository;
import com.gestion_banque.dao.OperationRepository;
import com.gestion_banque.entities.Compte;
import com.gestion_banque.entities.Operation;
import com.gestion_banque.entities.Retrait;
import com.gestion_banque.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRespository    compteRepository;

    @Override
    @Transactional // si tous ce passe bien la transaction et faite
    public boolean verser( String code, double montant) {

        // On charge le compte
        Compte cp = compteRepository.getOne( code );
        Operation o = new Versement();

        // mettre a jour date et montant compte et employe
        o.setDateOperation( new Date() );
        o.setMontant( montant );
        o.setCompte( cp );

        // mettre a jour le solde
        cp.setSolde( cp.getSolde() + montant );
        // sauvgarder l'operation
        operationRepository.save( o );

        return true;

    }

    @Transactional
    @Override
    public boolean retirer( String code, double montant) {
        Compte cp = compteRepository.getOne( code );
        if ( cp.getSolde() < montant )
            throw new RuntimeException( "Solde insuffisant !" );
        Operation o = new Retrait();
        // mettre a jour date et montant compte et employe
        o.setDateOperation( new Date() );
        o.setMontant( montant );
        o.setCompte( cp );
        // sauvgarder l'operation
        // mettre a jour le solde
        cp.setSolde( cp.getSolde() - montant );
        operationRepository.save( o );
        return true;

    }

    @Transactional
    @Override
    public boolean virement( String cpte1, String cpte2, double montant) {
        // on utilise la méthode reirer puis verser
    	if(cpte1.equals(cpte2))
    		throw new RuntimeException("Impossible le virement sur le meme compte");
    	
    	
        retirer( cpte1, montant);
        verser( cpte2, montant);

        return true;
    }

    @Override
    public PageOperation getOperations( String codeCompte, int page, int size ) {

        Page<Operation> ops = operationRepository.getOperations( codeCompte, PageRequest.of(page, size) );

        PageOperation pOp = new PageOperation();
        pOp.setOperations( ops.getContent() ); // get content retourne la liste
                                               // des operations
        pOp.setNmbreOperations( ops.getNumberOfElements() ); // nombre
                                                             // operations
        pOp.setPage( page ); // ops.getNumber()
        pOp.setTotalPages( ops.getTotalPages() );
        pOp.setTotalOperations((int) ops.getTotalElements() );
        return pOp;

    }

	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		Compte c = compteRepository.getOne(codeCpte);
		/*
		 * if(c == null) { throw new RuntimeException("Compte introuvable"); }
		 */
			
		return c;
	}

	@Override
	public Page<Operation> listOperation(String codecpte, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.getOperations(codecpte, PageRequest.of(page, size));
	}

	@Override
	public Optional<Compte> consulterCompteM1(String codeCpte) {
		// TODO Auto-generated method stub
		 Optional<Compte> c = compteRepository.findById(codeCpte);
		 if ( c == null )
	            throw new RuntimeException("Compte est introuvable !" );
		 
		 return c;
	}

	@Override
	public List<Compte> ConsulterAllComptes() {
		// TODO Auto-generated method stub
		List<Compte> CompteAll = compteRepository.findAll();
		
		return CompteAll;
	}
	
	

}
