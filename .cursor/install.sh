#!/usr/bin/env bash
# Idempotent Cloud Agent bootstrap for the algorithm-notes Maven project.
set -euo pipefail

# The default Cloud Agent image ships a JDK (21) but not Maven, so install it
# from the Ubuntu archive when it is missing. apt is idempotent, so this is a
# no-op on boots where Maven is already present.
if ! command -v mvn >/dev/null 2>&1; then
  sudo apt-get update
  sudo DEBIAN_FRONTEND=noninteractive apt-get install -y maven
fi

# Build the module and warm the local Maven repository so subsequent commands
# (and offline boots) do not need to re-download plugins and dependencies.
mvn -B -f algorithm/pom.xml -DskipTests clean package
