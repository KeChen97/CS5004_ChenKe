public class PetRock{
 private String name;
 private double weight;
 private boolean happy = false;

 public PetRock(String name, double weight) {
  if(name.isEmpty()){
   throw new IllegalArgumentException("Name cannot be empty");
  }
  this.name = name;
  this.weight = weight;
 }

 public String getName() {
  return this.name;
 }

 public double getWeight() {
  return this.weight;
 }

 public boolean isHappy() {
  return this.happy;
 }

 public void playWithRock(){
  this.happy = true;
 }

 public String getHappyMessage()throws IllegalArgumentException {
  if(!this.happy){
   throw new IllegalArgumentException();
  }
  return "I am happy.";
 }

 public boolean isSameRock (PetRock other){
  return this.name==other.getName() && this.weight == other.getWeight();
 }

 @Override
 public String toString() {
  return "PetRock: " +
      "name = " + name + ", "+
      "weight = " + weight + "g, " +
      "happy? " + happy;
 }
}

