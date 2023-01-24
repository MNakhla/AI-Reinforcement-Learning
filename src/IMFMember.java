public class IMFMember {

    public Position position;
    public int health;
	public boolean isCarried = false;
	public boolean isInSubmarine = false;

    public IMFMember(Position position, int health) {
        this.position = position;
        this.health = health;
	}
	public IMFMember(Position position, int health,boolean isCarried,boolean isInSubmarine) {
        this.position = position;
		this.health = health;
		this.isCarried=isCarried;
		this.isInSubmarine=isInSubmarine;
	}
	
	public boolean isDead(){
		return health>=100;
	}

	public Position getPosition() {
		return position;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isCarried() {
		return isCarried;
	}

	public void setCarried(boolean isCarried) {
		this.isCarried = isCarried;
	}

	public boolean isInSubmarine(){
		return isInSubmarine;
	}

	public void isInSubmarine(boolean isInSubmarine){
		 this.isInSubmarine=isInSubmarine;
	}

}
