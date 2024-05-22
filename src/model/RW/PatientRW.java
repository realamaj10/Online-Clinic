package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.baza.Patient;
import model.baza.Patient;

public class PatientRW {
	private final File fp;
	private ArrayList<Patient> pat;
	
	public PatientRW(){
		fp=new File("patient.ser");
		pat=new ArrayList<Patient>();
		if(!fp.exists()){
			writePat();
		} else {
			pat=readPat();
		}
	}

	private ArrayList<Patient> readPat() {
		try {
			FileInputStream fis=new FileInputStream(fp);
			ObjectInputStream ois=new ObjectInputStream(fis);
			pat=(ArrayList<Patient>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable!!!");
		}
		return null;
	}

	private void writePat() {
		try {
			FileOutputStream fos = new FileOutputStream(fp);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(pat);
			oos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
	}
	public void addPat(Patient p){
		pat.add(p);
		writePat();
	}
	public void removePat(Patient p){
		pat.remove(p);
		writePat();
	}
	public Patient getPatient(int id){
		for(Patient x:pat){
			if(x.getPid()==id){
				return x;
			}
		}
		return null;
	}
}
