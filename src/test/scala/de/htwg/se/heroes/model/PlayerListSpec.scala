package de.htwg.se.heroes.model

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.ListMap

class PlayerListSpec extends WordSpec with Matchers {

  "A PlayerList" when {
    "add player " should {
      val emptyPlayerList = new PlayerList
      "have value '' and 0" in {
        emptyPlayerList.addPlayer("janko", 0, 0, new ListMap[Cell, Int], 1, 1)
        emptyPlayerList.getPlayer should be(Player("janko", 0, 0, new ListMap[Cell, Int], 1, 1))
      }
    }
  }
}