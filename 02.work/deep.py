def reward_function(params: dict[str, float]) -> float:
    # Exemplo de função que recompensa o agente que segue o centro da pista

    # Lendo parâmetros 
    track_width = params['track_width']
    distance_from_center = params['distance_from_center']

    # Calcule 3 marcadores que a distância varia da linha central
    marker_1 = 0.1 * track_width
    marker_2 = 0.25 * track_width
    marker_3 = 0.5 * track_width

    # Dando uma maior recompensa para quando o agente está mais próximo ao centro
    if distance_from_center <= marker_1:
        reward = 1.0
    elif distance_from_center <= marker_2:
        reward = 0.5
    elif distance_from_center <= marker_3:
        reward = 0.1
    else:
        reward = 1e-3 # carrinho saiu da pista

    return float(reward)