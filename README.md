# AdventureGame

## Explanation
**A basic text-based adventure game implemented with Object Oriented Programming on Java.**

**Game includes 5 locations: Safehouse, Shop, Cave, Forest, River.**
**Battle Locations:**  Cave, Forest, River.
**Safe Locations:** Safehouse, Shop.

* Player chooses a character at the beginning of the game. These characters have different damage & health points with starting balances.
* Player wins the game by obtainining food, water and firewood by clearing each battle location.
* Player loses if he/she dies in any of these locations.
* Battle locations have various monsters with gold loots, these monsters respawn after all of them are slayed.
* Player regenerates health in safehouse.
* Player can buy weapons and armors from shop.

## Characters

| ID | Name    | Damage | Health | Balance |
|----|---------|--------|--------|---------|
| 1  | Samurai | 5      | 21     | 15      |
| 2  | Archer  | 7      | 18     | 20      |
| 3  | Knight  | 8      | 24     | 5       |

## Monsters

| ID | Name    | Damage | Health | Loot |
|----|---------|--------|--------|------|
| 1  | Zombie  | 3      | 10     | 4    |
| 2  | Vampire | 4      | 14     | 7    |
| 3  | Bear    | 7      | 20     | 12   |

## Weapons

| ID | Name   | Damae | Cost |
|----|--------|-------|------|
| 0  | None   | 0     | 0    |
| 1  | Pistol | 2     | 25   |
| 2  | Sword  | 3     | 35   |
| 3  | Rifle  | 7     | 45   |

## Armors

| ID | Name   | Block | Cost |
|----|--------|-------|------|
| 0  | None   | 0     | 0    |
| 1  | Light  | 1     | 15   |
| 2  | Middle | 3     | 25   |
| 3  | Heavy  | 5     | 40   |

## Locations
**Safehouse**
* Regenerate Health

**Cave**
* Mob: Zombie (1-3)
* Specialty: Battle + Loot
* Drop: Food

**Forest**
* Mob: Vampire (1-3)
* Specialty: Battle + Loot
* Drop: Firewood

**River**
* Mob: Bear (1-3)
* Specialty: Battle + Loot
* Drop: Water

**Shop**
* Specialty: User can purchase items.
* Weapons: Pistol, Sword, Rifle
* Armor: Light, Middle, Heavy
