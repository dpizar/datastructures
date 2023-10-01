package ca.pinesoul
package lists

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SinglyListTest extends AnyFlatSpec with Matchers {
  behavior of "appendToHead Function"
  
  it should "Append a SimpleNode to the head of an empty SinglyList" in {
    val valueToAppend = 8
    val singlyList = SinglyList[Int]

    singlyList.appendToHead(valueToAppend)

    valueToAppend shouldEqual singlyList.head.get.data
  }

  it should "Append a SimpleNode to the head of SinglyList with some elements in it" in {
    val tailValue = 75
    val oldHeadValue = 45
    val valueToAppend = 8

    val singlyList = SinglyList[Int]
    singlyList.appendToHead(tailValue)
    singlyList.appendToHead(oldHeadValue)

    singlyList.appendToHead(valueToAppend)

    valueToAppend should equal(singlyList.head.get.data)
    tailValue should equal(singlyList.getTailforNode(singlyList.head.get).data)
    3 shouldEqual singlyList.length
  }


  behavior of "appendToTail Function"

  it should "Append a SimpleNode to the end of an empty SinglyList" in {
    val valueToAppend = 8
    val singlyList = SinglyList[Int]

    singlyList.appendToTail(valueToAppend)

    valueToAppend shouldEqual singlyList.head.get.data
  }

  it should "Append a SimpleNode to the end of SinglyList with some elements in it" in {
    val tailValue = 75
    val headValue = 45
    val valueToAppend = 8

    val singlyList = SinglyList[Int]
    singlyList.appendToTail(headValue)
    singlyList.appendToTail(tailValue)

    singlyList.appendToTail(valueToAppend)

    headValue should equal(singlyList.head.get.data)
    valueToAppend should equal(singlyList.getTailforNode(singlyList.head.get).data)
    3 shouldEqual singlyList.length
  }

  behavior of "deleteFirst function"

  it should "leave the SinglyList empty, when there is only one element that matches the value" in {
    val valueToDeleteFirstOccurance = 8
    val singlyList = SinglyList[Int]
    singlyList.appendToTail(8)

    val deletedNode = singlyList.deleteFirst(valueToDeleteFirstOccurance)

    deletedNode.get.data shouldEqual valueToDeleteFirstOccurance
  }

  it should "remove node and return it, when the list has many elements and only one matches for deletion" in {
    val valueToDeleteFirstOccurance = 8
    val singlyList = SinglyList[Int]
    singlyList.appendToHead(10)
    singlyList.appendToHead(8)
    singlyList.appendToHead(6)
    singlyList.appendToHead(2)

    val deletedNode = singlyList.deleteFirst(valueToDeleteFirstOccurance)

    deletedNode.get.data shouldEqual valueToDeleteFirstOccurance
    10 should equal(singlyList.getTailforNode(singlyList.head.get).data)
    3 shouldEqual singlyList.length
  }

  it should "remove node and return it, when the list has many elements and the matching node is at the tail" in {
    val valueToDeleteFirstOccurance = 8
    val singlyList = SinglyList[Int]
    singlyList.appendToHead(8)
    singlyList.appendToHead(10)
    singlyList.appendToHead(6)
    singlyList.appendToHead(2)

    val deletedNode = singlyList.deleteFirst(valueToDeleteFirstOccurance)

    deletedNode.get.data shouldEqual valueToDeleteFirstOccurance
    10 should equal(singlyList.getTailforNode(singlyList.head.get).data)
    3 shouldEqual singlyList.length
  }

}
