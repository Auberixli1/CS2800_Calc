package calc;

/**
 * This interface is to implement the visitor design pattern..
 *
 * @author Marcus Messer
 */
public interface Visitor {

  /**
   * This method will be implemented to visit number nodes.
   *
   * @param num The currently visited node.
   */
  void visit(NumberNode num);

  /**
   * This method will be implemented to visit operator nodes.
   *
   * @param op The currently visited node.
   */
  void visit(OperatorNode op);

}
