object StringOperations {

  def longestWord(input: String): String = {
    input.split(" ").maxBy(_.length)
  }

  def mostCommonWord(input: String): String = {
    var map:scala.collection.mutable.Map[String,Int] = scala.collection.mutable.Map()
    var mostFrequentWord = ""
    var mostFrequentWordCount = 0
    for (word<-input.split(" ")) {
      map(word) = map.getOrElse(word, 0) + 1
      if(map(word) > mostFrequentWordCount) {
        mostFrequentWord = word
        mostFrequentWordCount = map(word)
      }
    }
    mostFrequentWord
  }

  def mostFrequntLetter(input: String): Char = {
    input.groupBy(identity).maxBy(_._2.size)._1
  }

  def letterToWordMap(input: String): scala.collection.mutable.Map[Char, scala.collection.mutable.Set[String]] = {
    var map:scala.collection.mutable.Map[Char,scala.collection.mutable.Set[String]] = scala.collection.mutable.Map()
    for(word<- input.split(" ")) {
      for(letter<- word.toList) {
        var s = map.getOrElse(letter, scala.collection.mutable.Set())
        s.add(word)
        map(letter) = s
      }
    }
    map
  }

  def convertListOfStringToListOfChars(input:List[String]): List[Char] = {
    input.flatten
  }

  def main(args: Array[String]): Unit = {
    println(longestWord("hi rak hi aree u"))
    println(mostCommonWord("hi rah hi rah rah hi a a a"))
    println(mostFrequntLetter("hi rah hi rah rah hi a a a  a bbbbbbbbbbbbbbb"))
    println(letterToWordMap("hi rah hi rah rah hi a a a  a      "))
    println(convertListOfStringToListOfChars(List("Rakesh", "rahul")))
  }
}