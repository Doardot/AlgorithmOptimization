def troco_guloso(moedas: list[int], valor: int) -> tuple[dict[int, int], int]:
    """
    Calcula o menor número de moedas para dar o troco.

    :param moedas: Lista de valores das moedas disponíveis.
    :param valor: Valor total do troco.
    :return: Dicionário com a quantidade de cada moeda e número de iterações.
    """
    # Ordena as moedas em ordem decrescente
    moedas.sort(reverse=True)
    
    resultado = {}
    iteracoes = 0

    for moeda in moedas:
        if valor == 0:
            break
        iteracoes += 1  # Contabiliza a iteração
        quantidade = valor // moeda # divisão inteira
        if quantidade > 0:
            resultado[moeda] = quantidade # Adiciona a quantidade de moedas
            valor -= quantidade * moeda # Atualiza o valor restante

    if valor > 0:
        raise ValueError("Não foi possível dar o troco exato com as moedas fornecidas.")

    return resultado, iteracoes


# Testes
if __name__ == "__main__":
    moedas_disponiveis = [100, 25, 10, 5, 1]
    valor_troco = 289  # 2,89 em centavos

    resultado, iteracoes = troco_guloso(moedas_disponiveis, valor_troco)
    print(f"Resultado: {resultado}")
    print(f"Total de iterações: {iteracoes}")
