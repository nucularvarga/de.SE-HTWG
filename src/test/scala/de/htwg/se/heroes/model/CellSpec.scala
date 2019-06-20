package de.htwg.se.heroes.model

import de.htwg.se.heroes.model.fieldComponent.Cell
import org.scalatest.{Matchers, WordSpec}

class CellSpec extends WordSpec with Matchers {

  "A Cell" when {
    "an empty Cell " should {
      val emptyCell = new Cell()
      "have value ' '" in {
        emptyCell.typ should be(" ")
        emptyCell.toString should be(" ")
      }
    }
  }

}