# Eearrape Plugin

## Overview
**Eearrape** is a fun and simple Minecraft plugin designed to troll players by blasting the loudest sounds imaginable into their game. It’s a great way for server admins to mess with their players for comedic effect, with highly customizable messages and a timeout feature to control the duration of the sound.

Whether you want to troll one player or all players on the server, this plugin offers full control over the trolling experience!

## Features
- **Loud Sound Effects**: Unleashes the loudest Minecraft sounds, causing maximum disruption for your players.
- **Customizable Messages**: Set unique messages to accompany the sound, tailoring the experience to your trolling needs.
- **Timeout Control**: Set a timeout for how long the ear-raping sound lasts.
- **Permission-Based Usage**: Only admins with the correct permission can use the plugin.

## Requirements
- Minecraft server version >1.8.9 (Adjust to your version)
- **Spigot** or **Paper** plugin support
- Admin permission to use commands

## Installation

1. Download the plugin `.jar` file and place it in your server's `plugins` folder.

2. Restart or reload your server to enable the plugin.

3. Configure the plugin by editing the `config.yml` file to suit your needs (optional).

## Permissions

### `earrape.permission`
Admins must have the `earrape.permission` to use the `/earrape` command.

## Commands

### `/earrape [player] [timeout]`
- **Description**: Blasts a loud sound into the specified player’s game, sends them a customizable message, and controls how long the sound lasts (timeout in seconds).
- **Usage**: `/earrape <player> <timeout>`
- If no player is specified, it will affect all players on the server.
- If no timeout is specified, it will run infinitly until you trigger the command again.

### Example:
```bash
/earrape Steve 10
