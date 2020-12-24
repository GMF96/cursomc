package com.gustavo.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.cursomc.domain.Cidade;
import com.gustavo.cursomc.domain.Estado;
import com.gustavo.cursomc.dto.CidadeDTO;
import com.gustavo.cursomc.dto.EstadoDTO;
import com.gustavo.cursomc.services.CidadeService;
import com.gustavo.cursomc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> find() {
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDto = list.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{estado_id}/cidades")
	public ResponseEntity<List<CidadeDTO>> findByEstado(@PathVariable Integer estado_id) {
		List<Cidade> list = cidadeService.findByEstado(estado_id);
		List<CidadeDTO> listDto = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
