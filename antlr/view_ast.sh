#!/bin/bash

if [ "$#" -eq 0 ]; then
    echo $'\nNo arguments provided.'
    echo $'Usage: sh view_ast.sh [grammar_name] [grammar_rule]\n'
    exit 1
elif [ "$#" -eq 1 ]; then
    echo $'\nMissing arguments.'
    echo $'Usage: sh view_ast.sh [grammar_name] [grammar_rule]\n'
    exit 1
fi


# Variables
parsers="parsers/"
name=$1                                  # first command line argument
rule=$2                                  # second command line argument
parser_dir="$parsers$name"               # /parsers/[parser_name]

g4=".g4"
grammars_dir="grammars/"
grammar_name="$name$g4"                     #.g4 file name
grammar_file="$grammars_dir$grammar_name"   # /grammars/[filename].g4


# Adding ANTLR4 to the classpath 
export CLASSPATH=".:$PWD/antlr-4.11.1-complete.jar:$CLASSPATH"


# Setting up aliases for ANTLR4 and GRUN
alias antlr4='java -Xmx500M -cp "$PWD/antlr-4.11.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp "$PWD/antlr_env/antlr-4.11.1-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'


# Compile generated Java files
echo $'> compiling generated Java files'
cd $parser_dir
javac *.java


# Show resulting parse tree
echo $'> paste input'
grun $name $rule -gui
