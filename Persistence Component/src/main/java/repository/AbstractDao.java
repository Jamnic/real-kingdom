package repository;

public interface AbstractDao<T> {

	void save(T t);

}