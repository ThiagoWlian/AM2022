package com.amye.AMEY.SERVICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.REPOSITORY.HabilidadesRepository;

@Service
public class HabilidadesService {
	
	@Autowired
	HabilidadesRepository habilidadesRepository;
	
	public List<HabilidadeModel> listarHabilidadesPelaVaga(){
		return habilidadesRepository.findHabilidadesPorVagaId(1);
	}
	
	public HabilidadeModel cadastrarHabilidade(HabilidadeModel habilidade){
		
		Optional<HabilidadeModel> habilidadeBusca = buscarHabilidadePeloNome(habilidade.getNome());
		if(habilidadeBusca.isPresent()) {
			return habilidadesRepository.save(habilidade);
		}
		return habilidadeBusca.get();
		
	}
	
	public List<HabilidadeModel> cadastarListaDeHabilidades(List<HabilidadeModel> listaHabilidades) {
		List<HabilidadeModel> habilidades = new ArrayList<HabilidadeModel>();
		HabilidadeModel habilidadePersistida;
		for(HabilidadeModel habilidade : listaHabilidades) {
			Optional<HabilidadeModel> habilidadeBusca = buscarHabilidadePeloNome(habilidade.getNome());
			if(habilidadeBusca.isEmpty()) {
				habilidadePersistida = habilidadesRepository.save(habilidade);
			} else {
				habilidadePersistida = habilidadeBusca.get();
			}
			habilidades.add(habilidadePersistida);
		}
		
		return habilidades;
	}
	
	private Optional<HabilidadeModel> buscarHabilidadePeloNome(String nome) {
		return habilidadesRepository.findByNome(nome);
	}
}
