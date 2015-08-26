#ElvenExperience

A Botania addon based on a [typo](https://www.reddit.com/r/feedthebeast/comments/3hiou2/looking_for_feedback_for_a_new_concept_for/cu7s9e9).

I do have some *real* plans for this, however.

##Custom Botania Challenges

You can now make custom challenges for Botania. If you don't know what Botania Challenges are, look [here](http://botaniamod.net/changelog.php#r1-6-196).

It's a fairly simple process and requires very minimal work.

1. Navigate to `../config/ElvenExperience/` and open up `CustomChallenges.json` in your favorite text editor.
2. In between the brackets, begin adding new Challenge objects like so:
 ```json
 
  {
    "name": "get.cobble",
    "level": "NORMAL",
    "stack": "minecraft:cobblestone"
  }
 ```
 This would produce a Challenge that looks like [this](http://i.imgur.com/wEjBBzP.png).
3. Here is the only part that must be done outside of the mod. You need to download and install [ResourceLoader](http://minecraft.curseforge.com/mc-mods/226447-resource-loader) (or any other mod of the sort) and have it load a lang file with the keys you see in that screenshot.
 In this case, you would need to add the following lines to your lang file:
 
 * `botania.challenge.get.cobble=Get Cobblestone`
 
 * `botania.challenge.get.cobble.desc=Obtain some cobblestone.`
 
 Which will end up looking like [this](http://i.imgur.com/sroQY6Y.png).
 
 Alternatively, you could use a Resource Pack.
4. Get to finishing all those new challenges!

###Field Explanations
| Field | Type   | Default    | Explanation                                                                                                                                                         |
|-------|--------|------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| name  | String | *Required* | The name of the challenge. Also used for the description unlocalized name. Becomes `botania.challenge.%NAME%` and `botania.challenge.%NAME%.desc` for localization. |
| level | String | *Required* | The level of the challenge. Valid inputs are `EASY`, `NORMAL`, `HARD`, and `LUNATIC`. Casing does not matter.                                                       |
| stack | String | *Required* | A string to be parsed into an ItemStack. The format is `modid:regname:meta` with `meta` being optional.                                                             |