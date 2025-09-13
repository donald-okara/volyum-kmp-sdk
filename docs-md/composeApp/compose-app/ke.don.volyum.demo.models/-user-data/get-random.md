//[composeApp](../../../index.md)/[ke.don.volyum.demo.models](../index.md)/[UserData](index.md)/[getRandom](get-random.md)

# getRandom

[common]\
fun [getRandom](get-random.md)(): [UserData](index.md)

Generates a random [UserData](index.md) object. The ID is a random number between 2 and 1000, converted to a string. The name is a randomly selected name from [FauxData.randomNames](../-faux-data/random-names.md). The profile URL is generated using picsum.photos with the generated ID as the seed.

#### Return

A new [UserData](index.md) instance with randomized data.