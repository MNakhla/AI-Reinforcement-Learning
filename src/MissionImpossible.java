import java.util.*;

public class MissionImpossible extends SearchProblem {

    static Set<Operator> operators = new HashSet<>(Arrays.asList(new Operator("UP"),new Operator("DOWN"),new Operator("LEFT"),new Operator("RIGHT"),new Operator("CARRY"),new Operator("DROP")));  

    public MissionImpossible(MissionImpossibleState intialState){
        super(intialState,operators); 
    }

	@Override
	State transition(State currentState, Operator operator) {
        if(currentState instanceof MissionImpossibleState){
            MissionImpossibleState MIState =(MissionImpossibleState) currentState;
            if(MIState.canEthan(operator)){
                MissionImpossibleState newMIState =new MissionImpossibleState();
                newMIState.setGridMaxX(MIState.getGridMaxX());
                newMIState.setGridMaxY(MIState.getGridMaxY());
                newMIState.setSubmarine(MIState.getSubmarine());
                newMIState.setTruckCapacity(MIState.getTruckCapacity());

                ArrayList<IMFMember> newIMFMembers=new ArrayList<IMFMember>();

                switch(operator.getName()){
                    case "UP":
                        newMIState.setEthan(new Position(MIState.getEthan().getX()-1,MIState.getEthan().getY()));
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));

                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);
                    break;
                    case "DOWN":
                        newMIState.setEthan(new Position(MIState.getEthan().getX()+1,MIState.getEthan().getY()));
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));

                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);
                    break;
                    case "LEFT":
                        newMIState.setEthan(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()-1));
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));

                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);

                    break;
                    case "RIGHT":
                        newMIState.setEthan(new Position(MIState.getEthan().getX()-1,MIState.getEthan().getY()+1));
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));

                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);

                    break;
                    case "DROP":
                        newMIState.setEthan(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()));
                        newMIState.setIMFInTruck(0);
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getSubmarine().getX(),MIState.getSubmarine().getY()), member.getHealth(),member.isCarried(),true));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));
                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);

                    break;
                    case "CARRY":
                        newMIState.setEthan(new Position(MIState.getEthan().getX(),MIState.getEthan().getY()));
                        newMIState.setIMFInTruck(MIState.getIMFInTruck()+1);
                        for (IMFMember member : MIState.getIMFMembers()) {
                            if(!member.isCarried() && !member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(MIState.getSubmarine().getX(),MIState.getSubmarine().getY()), member.getHealth(),true,false));

                            }else if (member.isInSubmarine()){
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth(),member.isCarried(),member.isInSubmarine()));

                            }
                            else{
                                newIMFMembers.add(new IMFMember(new Position(member.getPosition().getX(),member.getPosition().getY()), member.getHealth()+2,member.isCarried(),member.isInSubmarine()));
                            }
                        }
                        newMIState.setIMFMembers(newIMFMembers);
                    break;
                    default:
                }
                return newMIState;
            }
        }
		return null; //operator can't be applied
	}

	@Override
	boolean goalTest(State currentState) {
        if(currentState instanceof MissionImpossibleState){
            MissionImpossibleState MIstate =(MissionImpossibleState) currentState;
            if(MIstate.isAllIMFInSubmarine() && MIstate.isEthanAtSubmarine()){
                return true;
            }
        }
        return false;
	}

	@Override
	int pathCost(State state, Operator operator) {
        // TODO Auto-generated method stub
        
		return 0;
	}

	@Override
	int heuristic() {
		// TODO Auto-generated method stub
		return 0;
    };
    
    public static String genGrid() {

        int gridRows = (int) (Math.random() * (16 - 5 + 1) + 5);
        int gridColumns = (int) (Math.random() * (16 - 5 + 1) + 5);
        int[][] Map = new int[gridRows][gridColumns];

        int IMFs = (int) (Math.random() * (11 - 5 + 1) + 5);
        int c = (int) (Math.random() * ((IMFs + 1) - 1 + 1) + 1);
        ArrayList<IMFMember> posIMF = new ArrayList<IMFMember>(IMFs);

        int occupiedSpots = 0;
        Random random = new Random();
        while (occupiedSpots < IMFs) {
            int row = random.nextInt(gridRows);
            int col = random.nextInt(gridColumns);
            if (Map[row][col] == 0) {
                Map[row][col] = 1;
                posIMF.add(new IMFMember(new Position(row, col), (int) (Math.random() * (100 - 1 + 1) + 1)));
                occupiedSpots++;
            }
        }

        int ethanRow = 0;
        int ethanCol = 0;

        int submarineRow = 0;
        int submarineCol = 0;

        occupiedSpots = 0;
        while (occupiedSpots < 2) {
            int row = random.nextInt(gridRows);
            int col = random.nextInt(gridColumns);
            if (Map[row][col] == 0) {
                Map[row][col] = 1;
                if (occupiedSpots == 0) {
                    ethanRow = row;
                    ethanCol = col;
                } else {
                    submarineRow = row;
                    submarineCol = col;
                }

                occupiedSpots++;
            }
        }
        String IMFpos = "";
        String IMFhealth = "";
        for (int z = 0; z < posIMF.size(); z++) {
            IMFpos = IMFpos + posIMF.get(z).getPosition().getX() + "," + posIMF.get(z).getPosition().getY() + ",";
            IMFhealth = IMFhealth + posIMF.get(z).getHealth() + ",";
        }
        return gridRows + "," + gridColumns + ";" + ethanRow + "," + ethanCol + ";" + submarineRow + "," + submarineCol
                + ";" + StringCleaner(IMFpos) + ";" + StringCleaner(IMFhealth) + ";" + c;
    }

    public static String StringCleaner(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void visualize(String grid) {
        String[] info = grid.split(";");

        String[] gridDimensions = info[0].split(",");
        String[] ethanPos = info[1].split(",");
        String[] submarinePos = info[2].split(",");
        String[] posIMFs = info[3].split(",");
        String[] healthIMFs = info[4].split(",");

        int gridRows = Integer.parseInt(gridDimensions[0]);
        int gridCols = Integer.parseInt(gridDimensions[1]);

        int ethanRow = Integer.parseInt(ethanPos[0]);
        int ethanCol = Integer.parseInt(ethanPos[1]);
        int submarineRow = Integer.parseInt(submarinePos[0]);
        int submarineCol = Integer.parseInt(submarinePos[1]);

        String[][] Map = new String[gridRows][gridCols];

        ArrayList<IMFMember> infoIMFs = new ArrayList<IMFMember>();

        for (int i = 0; i < healthIMFs.length; i++) {
            if (i == 0) {
                infoIMFs.add(new IMFMember(new Position(Integer.parseInt(posIMFs[i]), Integer.parseInt(posIMFs[i + 1])),
                        Integer.parseInt(healthIMFs[i])));
            } else {
                infoIMFs.add(new IMFMember(new Position(Integer.parseInt(posIMFs[i * 2]), Integer.parseInt(posIMFs[i * 2 + 1])),
                        Integer.parseInt(healthIMFs[i])));
            }
        }

        Map[ethanRow][ethanCol] = "E";
        Map[submarineRow][submarineCol] = "S";

        // System.out.println(infoIMFs.size());

        for (int z = 0; z < infoIMFs.size(); z++) {
            Map[infoIMFs.get(z).getPosition().getX()][infoIMFs.get(z).getPosition().getY()] = "F" + "(" + infoIMFs.get(z).getHealth()+ ")";
        }

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                if (Map[r][c] == null) {
                    Map[r][c] = "0";
                }
            }
        }

        for (String[] row : Map) {
            printRow(row);
        }

    }

    public static void printRow(String[] row) {
        for (String i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }


    public static String solve(String grid,SearchStrategy strategy,boolean visualize){
        // generalSearchProcedure(problem, strategy);
        //plan;deaths;healths;nodes
        return null;
    }

    public static void main(String[] args) {
        // MissionImpossible MI =new MissionImpossible(new MissionImpossibleState(genGrid()));
        // MI.solve();
        String grid = genGrid();
        System.out.println(grid);
        System.out.println("");
        visualize(grid);
    }

	
	
}
