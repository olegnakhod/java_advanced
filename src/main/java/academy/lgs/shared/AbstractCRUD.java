package academy.lgs.shared;

import java.util.List;

public interface AbstractCRUD<T> {
	
	T create(T t);

	T read(Integer id);

	void update(Integer id);

	void delete(Integer id);
	
	List<T> readAll();

}
