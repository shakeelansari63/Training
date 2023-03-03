from ply import lex

# Token to catch
tokens = ("plus", "minus", "multiply", "divide", "lpar", "rpar", "number")

# Regex Rules for each token. Name of rule is t_<token name>
t_plus = r'\+'
t_minus = r'\-'
t_multiply = r'\*'
t_divide = r'/'
t_lpar = r'\('
t_rpar = r'\)'

# for some additional operation on token, create function with name t_<token>
def t_number(t):
    r'\d+'
    t.value = int(t.value)
    return t

# This increments line without considering it as token as we are not returning anything
def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

# This simply ignores white spaces as we are not returning anything
def t_whitespace(t):
    r'[\s\t]+'

# t_error catches any error
def t_error(t):
    print(f'Illegal Character: {t.value}')
    t.lexer.skip(1)

lexer = lex.lex()

if __name__ == "__main__":
    data = '3 +(4-7)*2'

    lexer.input(data)

    # Looping over each token and display it
    tok = lexer.token()
    while tok:
        print(tok)
        tok = lexer.token()

