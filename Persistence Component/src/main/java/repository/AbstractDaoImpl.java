package repository;

public class AbstractDaoImpl<T> implements AbstractDao<T> {

	@Override
	public void save(T t) {
		System.out.println("SAVING");
	}

}
