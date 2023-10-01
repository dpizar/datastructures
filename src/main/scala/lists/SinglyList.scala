package ca.pinesoul
package lists

import scala.annotation.tailrec

class SinglyList[T <: AnyVal] {
  var head: Option[SimpleNode[T]] = None
  var length: Int = 0

  def appendToHead(value: T): Unit =
    val newHead = SimpleNode(value, None)
    head match {
      case None => head = Some(newHead)
      case Some(currentHead) =>
        head = Some(newHead)
        newHead.next = Some(currentHead)
    }
    length += 1


  def appendToTail(value: T): Unit =
    val tailNode = Some(SimpleNode(value, None))
    head match {
      case None => head = tailNode
      case Some(head) => getTailforNode(head).next = tailNode
    }
    length += 1

  def getTailforNode(node: SimpleNode[T]): SimpleNode[T] = node.next match
      case None => node
      case Some(notTail) => getTailforNode(notTail)

  def deleteFirst(value: T): Option[SimpleNode[T]] =  head.flatMap { headNode =>
      if headNode.data == value then
        removeHeadNode()
      else
        findPreviousNode(headNode, value).flatMap(previousNode => removeNode(previousNode))
  }

  private def removeHeadNode(): Option[SimpleNode[T]] = head.map { headToRemove =>
    head = headToRemove.next
    headToRemove.next = None
    length -= 1
    headToRemove
  }

  @tailrec
  private def findPreviousNode(node: SimpleNode[T], value: T): Option[SimpleNode[T]] = node.next match {
    case None => None
    case Some(nextNode) =>
      if nextNode.data == value then Some(node) else findPreviousNode(nextNode, value)
  }

  private def removeNode(previousNode: SimpleNode[T]): Option[SimpleNode[T]] = previousNode.next.map { nodeToRemove =>
      previousNode.next = nodeToRemove.next
      nodeToRemove.next = None
      length -= 1
      nodeToRemove
    }

  def findNodeWithValue(value: T): Option[SimpleNode[T]] = None
}
