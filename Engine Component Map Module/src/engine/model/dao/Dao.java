package engine.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import architecture.Entity;
import architecture.GameComponentContainer;

/**
 * 
 * @author djanicki
 * 
 * @param <T>
 */
public class Dao<T extends Entity> extends GameComponentContainer {

	/* ========== Public ========== */
	public void save(T t) {
		try {
			output.writeObject(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public T load() {
		try {
			return (T) input.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/* ========== Protected ========== */
	protected void initialize(File file) {
		try {
			output = new ObjectOutputStream(new FileOutputStream(file));
			input = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* ========== Private ========== */
	private ObjectOutputStream output;
	private ObjectInputStream input;

}
