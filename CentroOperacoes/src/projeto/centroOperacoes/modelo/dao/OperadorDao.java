package projeto.centroOperacoes.modelo.dao;


import projeto.centroOperacoes.modelo.Operador;

public class OperadorDao extends DaoGeneric<Operador>{

	public OperadorDao() {
		classPersistence = OperadorDao.class;
	}
	
	
	public void remove(Operador operador) {
        try {
                 entityManager.getTransaction().begin();
                 operador = entityManager.find(Operador.class, operador.getId());
                 entityManager.remove(operador);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
	
}
