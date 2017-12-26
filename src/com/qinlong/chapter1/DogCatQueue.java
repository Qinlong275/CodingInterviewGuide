package com.qinlong.chapter1;

import java.util.LinkedList;
import java.util.Queue;

//√®π∑∂”¡–

class Pet{
	private String type;

	public Pet(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}

class Dog extends Pet{
	public Dog(){
		super("dog");
	}
}

class Cat extends Pet{
	public Cat(){
		super("cat");
	}
}

class PetEnterQueue{
	private Pet pet;
	private long count;
	
	public PetEnterQueue(Pet pet, long count) {
		super();
		this.pet = pet;
		this.count = count;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public long getCount() {
		return count;
	}
	
	public String getEnterPetType() {
		return pet.getType();
	}
}
public class DogCatQueue {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	
	public DogCatQueue(){
		dogQ=new LinkedList<>();
		catQ=new LinkedList<>();
		count=0;
	}
	
	public void addPet(Pet pet) {
		if (pet.getType().equals("dog")) {
			dogQ.add(new PetEnterQueue(pet, count++));
		}else if (pet.getType().equals("cat")) {
			catQ.add(new PetEnterQueue(pet, count++));
		}else {
			throw new RuntimeException("no cat or dog");
		}
	}
	
	public Pet pollAll() {
		if (!dogQ.isEmpty()&&!catQ.isEmpty()) {
			if (dogQ.peek().getCount()<catQ.peek().getCount()) {
				return dogQ.poll().getPet();
			}else {
				return catQ.poll().getPet();
			}
		}else if (!dogQ.isEmpty()) {
			return dogQ.poll().getPet();
		}else if (!catQ.isEmpty()) {
			return catQ.poll().getPet();
		}else {
			throw new RuntimeException("queue is empty");
		}
	}
	
	public Dog pollDog() {
		if (!dogQ.isEmpty()) {
			return (Dog)dogQ.poll().getPet();
		}else {
			throw new RuntimeException("dogQueue is empty");
		}
	}
	
	public Cat pollCat() {
		if (!catQ.isEmpty()) {
			return(Cat)catQ.poll().getPet();
		}else {
			throw new RuntimeException("catqueue is empty");
		}
	}
	
	public boolean isEmpty() {
		return dogQ.isEmpty()&&catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty() {
		return dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty() {
		return catQ.isEmpty();
	}
}
