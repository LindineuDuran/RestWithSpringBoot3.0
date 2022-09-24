package br.com.llduran.integrationtests.vo.wrappers;

import br.com.llduran.integrationtests.vo.PersonVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PersonEmbeddedVO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("personVOList")
	private List<PersonVO> persons;
}
