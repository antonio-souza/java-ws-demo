package br.com.aaas.jwsdemo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class MensagemService {

  public List<String> enviarBomDia(String nome) {
    List<String> list = new ArrayList<String>();
    list.add("Bom");
    list.add("dia");
    list.add(nome);
    return list;
  }
}
