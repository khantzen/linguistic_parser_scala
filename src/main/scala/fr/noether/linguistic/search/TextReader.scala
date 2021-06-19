package fr.noether.linguistic.search

case class TextReader(headIndex: Int, taggedTokenList: Seq[TaggedToken]) extends Iterable[TaggedToken] {
  def next(): TextReader = TextReader(headIndex + 1, taggedTokenList)

  def currentTaggedToken(): TaggedToken = taggedTokenList(headIndex)

  def hasNext: Boolean = headIndex != taggedTokenList.size

  override def iterator: Iterator[TaggedToken] = taggedTokenList.iterator
}
