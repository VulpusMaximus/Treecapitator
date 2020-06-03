# TreecapitatorSpigot
 A Spigot plugin allowing players to fell trees in one go with an axe, based off the Forge mod.

## Usage
When a player with the `treecapitator.fell` permission breaks a log with an axe, the plugin will also break all other logs upwards and outwards.
Any logs directly below the original log broken will remain.

## Configuration
The plugin generates a configuration file when first loaded, under `plugins/Treecapitator/config.yml`.
The config file has the following options:
| Key | Value (Default) | Effect |
| --- | --------------- | ------ |
| `sneak-ignore`        | `true`/`false` (`true`)  | If enabled, causes logs to be broken as normal if sneaking while breaking. |
| `trees-have-leaves`   | `true`/`false` (`false`) | If enabled, causes trees to only be felled if they have leaves. Can be used to avoid you "felling" your own house. |
| `damage-per-block`    | `true`/`false` (`true`)  | If enabled, the player's axe is damaged for every log broken. |

## Licence
[![CC BY-NC-SA 4.0](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

This plugin is licensed under the [Creative Commons BY-NC-SA 4.0](http://creativecommons.org/licenses/by-nc-sa/4.0/) licence.
The original Treecapitator mod for Minecraft Forge was created by DaftPVF and continued by bspkrs under the 3.0 version of this licence.
This adaptation follows the idea, but not the code of the original versions.
You can find bspkrs' mod [here](https://github.com/bspkrs/Treecapitator).