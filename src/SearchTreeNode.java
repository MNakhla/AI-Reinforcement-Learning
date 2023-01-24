public class SearchTreeNode {
    State state;
    SearchTreeNode parentNode;
    Operator operator;
    int depth;
    int costFromRoot;

    public SearchTreeNode(State state, SearchTreeNode parentNode, Operator operator, int depth, int costFromRoot){
        this.state=state;
        this.parentNode=parentNode;
        this.operator=operator;
        this.depth=depth;
        this.costFromRoot=costFromRoot;
    }

    public SearchTreeNode(State state){
        this.state=state;
        this.depth=0;
        this.parentNode=null;
    }

    public State getState(){
        return state;
    }

	public Operator getOperator() {
        return operator;
    }
    public SearchTreeNode getParentNode(){
        return parentNode;
    }
    public int getDepth(){
        return depth;
    }
}
