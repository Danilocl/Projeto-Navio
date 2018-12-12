package projeto.centroOperacoes.modelo.dao;

import projeto.centroOperacoes.modelo.Tripulante;

public class TripulanteDao extends DaoGeneric<Tripulante> {

	public TripulanteDao() {
		classPersistence = TripulanteDao.class;
	}

	
	public void remove(Tripulante tripulante) {
        try {
                 entityManager.getTransaction().begin();
                 tripulante = entityManager.find(Tripulante.class, tripulante.getId());
                 entityManager.remove(tripulante);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
}
