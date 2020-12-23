package kr.ac.woosuk.java.fsg.models.shots;

public abstract class DoctorShot {
   public int attackpoint;
   public int position;


   
   public int  ItemPosition() {
      return position;
   }

   public int getAttackpoint() {
      
      return attackpoint;
   }

	public void addPower(int powerlevel) {
		this.attackpoint += powerlevel;
	}


}