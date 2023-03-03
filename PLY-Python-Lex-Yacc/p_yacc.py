from ply import yacc 
from p_lex import tokens

# Define parsing rules using p_<rule name> and Yacc rules are provided in docstring
def p_expressions(p):
    '''expr : expr plus expr
            | expr minus expr
            | expr multiply expr
            | expr divide expr
    '''
    print([x for x in p])
    
    if p[2] == '+':
        p[0] = p[1] + p[3]
    elif p[2] == '-':
        p[0] = p[1] - p[3]
    elif p[2] == '*':
        p[0] = p[1] * p[3]
    elif p[2] == '/':
        p[0] = p[1] / p[3]

def p_expr_in_paranthesis(p):
    'expr : lpar expr rpar'
    p[0] = p[2]

def p_number_expr(p):
    'expr : number'
    p[0] = p[1]

def p_error(p):
    print("Syntax error!")

if __name__ == "__main__":
    parser = yacc.yacc()

    inp_expr = input("Give Expression: ")

    result = parser.parse(inp_expr)
    print(result)