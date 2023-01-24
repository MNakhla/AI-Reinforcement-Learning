import java.util.ArrayList;

public class MissionImpossibleState implements State{
    Position ethan;
    ArrayList<IMFMember> IMFMembers;
    Position submarine;
    int IMFInTruck=0;
    int truckCapacity;
    int gridMaxX;
    int gridMaxY;

    public MissionImpossibleState(){
        
    }
    
    public MissionImpossibleState(String grid){
        String[] info = grid.split(";");

        String[] gridDimensions = info[0].split(",");
        String[] ethanPos = info[1].split(",");
        String[] submarinePos = info[2].split(",");
        String[] posIMFs = info[3].split(",");
        String[] healthIMFs = info[4].split(",");

        int gridMaxX = Integer.parseInt(gridDimensions[0]);
        int gridMaxY = Integer.parseInt(gridDimensions[1]);

        ArrayList<IMFMember> IMFMembers = new ArrayList<IMFMember>();

        for (int i = 0; i < healthIMFs.length; i++) {
            if (i == 0) {
                IMFMembers.add(new IMFMember(new Position(Integer.parseInt(posIMFs[i]), Integer.parseInt(posIMFs[i + 1])),
                        Integer.parseInt(healthIMFs[i])));
            } else {
                IMFMembers.add(new IMFMember(new Position(Integer.parseInt(posIMFs[i * 2]), Integer.parseInt(posIMFs[i * 2 + 1])),
                        Integer.parseInt(healthIMFs[i])));
            }
        }

        this.ethan = new Position(Integer.parseInt(ethanPos[0]), Integer.parseInt(ethanPos[1]));
        this.submarine = new Position(Integer.parseInt(submarinePos[0]), Integer.parseInt(submarinePos[1]));
        this.IMFMembers = IMFMembers;
        this.truckCapacity = Integer.parseInt(info[5]);
        this.gridMaxX=gridMaxX;
        this.gridMaxY=gridMaxY;
    }



    
    public int numberOfIMFInSubmarine(){
        int count =0;
        for (IMFMember imfMember : IMFMembers) {
            if(imfMember.isInSubmarine())
            count++;
        }
        return count;
    }

    public boolean isAllIMFInSubmarine(){
       return IMFMembers.size() == numberOfIMFInSubmarine();
    }

    public boolean isEthanAtSubmarine(){
        return ethan.getX()==submarine.getX() && ethan.getY()==submarine.getY();
    }

    public boolean canEthan(Operator operator){
        switch(operator.getName()){
            case "UP":
                if(ethan.getX()!=0)
                    return true;
            break;
            case "DOWN":
               if(ethan.getX()!=gridMaxX-1)
                    return true;
            break;
            case "LEFT":
                if(ethan.getY()!=0)
                    return true;
            break;
            case "RIGHT":
                if(ethan.getY()!=gridMaxY-1)
                    return true;
            break;
            case "DROP":
                if(isEthanAtSubmarine() && IMFInTruck>0){
                    return true;
                }
            break;
            case "CARRY":
                if(IMFInTruck<truckCapacity){
                    for (IMFMember imfMember : IMFMembers) {
                        if(!imfMember.isInSubmarine() && !imfMember.isCarried())
                            if(ethan.getX()==imfMember.getPosition().getX() && ethan.getY()==imfMember.getPosition().getY())
                                return true;
                    }
                }
            break;
            default:
                 return false;
        }
        return false;
    }

	public Position getEthan() {
		return ethan;
	}

	public void setEthan(Position ethan) {
		this.ethan = ethan;
	}

	public ArrayList<IMFMember> getIMFMembers() {
		return IMFMembers;
	}

	public void setIMFMembers(ArrayList<IMFMember> iMFMembers) {
		IMFMembers = iMFMembers;
	}

	public Position getSubmarine() {
		return submarine;
	}

	public void setSubmarine(Position submarine) {
		this.submarine = submarine;
	}

	public int getIMFInTruck() {
		return IMFInTruck;
	}

	public void setIMFInTruck(int iMFInTruck) {
		IMFInTruck = iMFInTruck;
	}

	public int getTruckCapacity() {
		return truckCapacity;
	}

	public void setTruckCapacity(int truckCapacity) {
		this.truckCapacity = truckCapacity;
	}

	public int getGridMaxX() {
		return gridMaxX;
	}

	public void setGridMaxX(int gridMaxX) {
		this.gridMaxX = gridMaxX;
	}

	public int getGridMaxY() {
		return gridMaxY;
	}

	public void setGridMaxY(int gridMaxY) {
		this.gridMaxY = gridMaxY;
	}

}