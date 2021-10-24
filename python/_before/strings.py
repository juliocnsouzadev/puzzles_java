def string_format(str):
    return "The string is {0} formatted. Cool not?".format(str)

def string_substitution(str):
    return "The string is %s substituted. Cool not?"%(str)




def main():
    formatted = string_format("Julio")
    print(formatted)
    substituted = string_substitution("Cesar")
    print(substituted)
    for i, c in enumerate(substituted):
        print('{},{}'.format(i,c))

    d = {1:'a', 2:'v'}
    l = range(1, 10,2)
    l2 = range(0,10,2)
    zipped = zip(l, l2)
    print(tuple(zipped))

if __name__ == '__main__':
    main()