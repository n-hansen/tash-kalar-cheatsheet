ifeq ($(origin .RECIPEPREFIX), undefined)
  $(error This Make does not support .RECIPEPREFIX. Please use GNU Make 4.0 or later)
endif
.RECIPEPREFIX = >

SHELL := bash
.SHELLFLAGS := -eu -o pipefail -c
.ONESHELL:
.DELETE_ON_ERROR:
MAKEFLAGS += --warn-undefined-variables
MAKEFLAGS += --no-builtin-rules

.PHONY: app clean

app: public/index.html public/js/main.js

public/js/main.js: shadow-cljs.edn $(shell find src -iname '*.cljs' -type f)
>npx shadow-cljs release :app

out/generate-noscript-page.js: shadow-cljs.edn $(shell find src -iname '*.cljs' -type f)
>npx shadow-cljs release :noscript

public/noscript.html: out/generate-noscript-page.js
>node out/generate-noscript-page.js > public/noscript.html

clean:
>rm -rf public/js/main.js public/js/cljs-runtime
>rm -f out/*
