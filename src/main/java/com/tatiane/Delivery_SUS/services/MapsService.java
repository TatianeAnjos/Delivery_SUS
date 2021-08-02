package com.tatiane.Delivery_SUS.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tatiane.Delivery_SUS.entities.Dto.DadosBuscaEnderecoDto;

@Component
public class MapsService {

	public DadosBuscaEnderecoDto buscarDadosEndereco(String logradouro, String cidade, String estado, String token) {

		Gson gson = new Gson();
		
		HttpClient httpclient = HttpClients.createDefault();
		
		String LogradouroFormatted = FormatarString(logradouro);
		String CidadeFormatted = FormatarString(cidade);	
		String completa = ("https://maps.googleapis.com/maps/api/geocode/json?address="+LogradouroFormatted+","+CidadeFormatted+","+estado+"&key="+token);

		HttpGet httpget = new HttpGet(completa);
		
		try {
			HttpResponse response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				System.out.println(content);
				DadosBuscaEnderecoDto dto = gson.fromJson(content, DadosBuscaEnderecoDto.class);
				return dto;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
		return null;
	}
	
	private String FormatarString(String nome) {
		return nome.replace(" ", "+");
	}
	
	public Double CalcularDistancia(double x1,double y1, double x2,double y2) {
		//calculando distancia em graus
		double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		//convertendo para quilometros
		return ( (distancia * 111.325));

	}
}