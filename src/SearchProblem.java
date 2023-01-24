import java.util.*;

abstract class SearchProblem {
    
  State intialState;
  Set<Operator> operators;

  public SearchProblem(State intialState, Set<Operator> operators){
      this.intialState=intialState;
      this.operators=operators;
  };

  abstract State transition(State state,Operator operator);    
  abstract boolean goalTest(State state);    
  abstract int pathCost(State state,Operator operator);    

  abstract int heuristic();

  public State getIntialState() {
    return intialState;
  }
  
  public Set<Operator> getOperators() {
		return operators;
	}
  
  public ArrayList<SearchTreeNode> expand(SearchTreeNode node){
      Set<Operator> operators=this.getOperators();
      ArrayList<SearchTreeNode> expandedNodes= new ArrayList<SearchTreeNode>();
      for (Operator operator : operators) {
        State newState= this.transition(node.getState(), operator);
        if(newState!=null){
              // expandedNodes.add(new SearchTreeNode(newState, node, operator, node.getDepth()+1, costFromRoot));
        }
      }
      return expandedNodes;
  }

  public SearchTreeNode search(SearchProblem problem,SearchStrategy strategy){
      ArrayList<SearchTreeNode> nodesList =new ArrayList<SearchTreeNode>();
      nodesList.add(new SearchTreeNode(intialState));
      while(!nodesList.isEmpty()){
          SearchTreeNode currentNode=nodesList.remove(0); //remove first 
          State currentState=currentNode.getState();
          if(problem.goalTest(currentState)){
              return currentNode; //node means success
          }
          nodesList=QingFun(strategy, nodesList, currentNode);
      }
      return null; //null means failure
  }

  public ArrayList<Operator> path(SearchTreeNode successNode){
      ArrayList<Operator> operatorsToGoal=new ArrayList<Operator>();
      return pathHelper(operatorsToGoal,successNode);
  }

  public ArrayList<Operator> pathHelper(ArrayList<Operator> operatorsToGoal,SearchTreeNode node){
      if(node.getParentNode()==null){
          return operatorsToGoal;
      }
      operatorsToGoal.add(node.getOperator());
    return pathHelper(operatorsToGoal, node.getParentNode());
  }



  public ArrayList<SearchTreeNode> QingFun(SearchStrategy strategy,ArrayList<SearchTreeNode> nodes ,SearchTreeNode currentNode){
    ArrayList<SearchTreeNode> expandedNodes=expand(currentNode);
    ArrayList<SearchTreeNode> newNodesList= new ArrayList<SearchTreeNode>();
    //Deep Cloning
    for (SearchTreeNode node : nodes) {
        newNodesList.add(node);
    }
    switch(strategy){
    case AS1:
      break;
    case AS2:
      break;
          case BF:
          for (SearchTreeNode node : expandedNodes) {
              newNodesList.add(0, node);//if stack add front
          }
      break;
          case DF:
              //add expanded nodes in specific order
              for (SearchTreeNode node : expandedNodes) {
                  newNodesList.add(node);//normal add in end
              }
      break;
    case GR1:
      break;
    case GR2:
      break;
    case ID:
      break;
    case UC:
      break;
    default:
      break;
      }

      return newNodesList;
  }


}
