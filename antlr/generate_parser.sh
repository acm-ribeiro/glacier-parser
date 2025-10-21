#!/bin/bash
if [ "$#" -eq 0 ]; then
    echo $'\nMissing argument.'
    echo $'Usage: sh run.sh [grammar_name]\n'
    exit 1
fi

# Variables
parsers="parsers/"
name=$1                                     # first command line argument
parser_dir="$parsers$name"              # /parsers/[parser_name]_parser

g4=".g4"
grammars_dir="grammars/"
grammar_name="$name$g4"                     #.g4 file name
grammar_file="$grammars_dir$grammar_name"   # /grammars/[filename].g4

# Removing previously used parser directory
rm -r $parser_dir

# Creating empty paser directory
mkdir $parser_dir

# Adding ANTLR4 to the classpath 
export CLASSPATH=".:$PWD/antlr-4.11.1-complete.jar:$CLASSPATH"

# Setting up aliases for ANTLR4 and GRUN
alias antlr4='java -Xmx500M -cp "$PWD/antlr-4.11.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp "$PWD/antlr_env/antlr-4.11.1-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'

# Run ANTLR4: generating java code (including visitor class)
antlr4 -visitor $grammar_file

# Moving the java classes to the respective parser directory
mv $grammars_dir/*.interp $parser_dir
mv $grammars_dir/*.tokens $parser_dir
mv $grammars_dir/*.java $parser_dir
