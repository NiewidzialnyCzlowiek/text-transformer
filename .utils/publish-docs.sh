#!/bin/bash
cd $HOME
git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"
git clone --quiet https://${GH_TOKEN}@github.com/NiewidzialnyCzlowiek/text-transformer text-transformer

# Commit and Push the Changes
cd text-transformer
mvn site
cp -Rf ./target/site ./docs
rm -r ./target
git add ./docs/**
git commit -m "Lastest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to /docs directory"
git push -fq origin master
