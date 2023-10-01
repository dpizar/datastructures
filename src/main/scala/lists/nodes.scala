package ca.pinesoul
package lists

case class SimpleNode[A <: AnyVal](data: A, var next: Option[SimpleNode[A]])

case class DoubleLinkedListNode[A <: AnyVal](data: A, var prev: Option[DoubleLinkedListNode[A]], var next: Option[DoubleLinkedListNode[A]])
