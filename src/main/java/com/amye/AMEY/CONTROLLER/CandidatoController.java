package com.amye.AMEY.CONTROLLER;

import com.amye.AMEY.DTO.JSONCONVERT.Data;
import com.amye.AMEY.MODEL.CurriculoModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import com.amye.AMEY.SERVICE.CurriculoService;
import com.amye.AMEY.SERVICE.ExperienciaService;
import com.amye.AMEY.SERVICE.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroCandidatoDto;
import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.UsuarioModel;
import com.amye.AMEY.SERVICE.CandidatoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	CandidatoService candidatoService;

	@Autowired
	FormacaoService formacaoService;

	@Autowired
	ExperienciaService experienciaService;

	@Autowired
	CurriculoService curriculoService;

	
	@GetMapping("/telaCadastro")
	public String telaCadastro() {
		return "cadastroInicial";
	}

	@GetMapping("/perfil")
	public String abrirPerfil(Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		CurriculoModel curriculo = curriculoService.buscarCurriculoPeloCandidato((candidato).getId());
		model.addAttribute("curriculo", curriculo);
		model.addAttribute("candidato", candidato);
		model.addAttribute("formacoes", curriculo.getFormacoes());
		model.addAttribute("experiencias", curriculo.getExperiencias());

		return "/perfilUsuario";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(CadastroCandidatoDto candidatoRequisicao) {
		CandidatoModel candidatoModel = candidatoRequisicao.transformarEmCandidato();
		UsuarioModel usuario = candidatoRequisicao.transformarEmUsuario();
		CandidatoModel candidatoCadastrado = candidatoService.cadastraCandidato(candidatoModel, usuario, candidatoRequisicao.getProfissao());

		String json = """
				{
				    "data": {
				        "certifications": [],
				        "dateOfBirth": null,
				        "education": [
				            {
				                "id": 4843196,
				                "organization": "Faculdade de Informática e Administração Paulista (FIAP)",
				                "accreditation": {
				                    "education": "Bacharelado, Sistemas de Informação",
				                    "educationLevel": null,
				                    "inputStr": "Bacharelado, Sistemas de Informação",
				                    "matchStr": ""
				                },
				                "grade": null,
				                "location": null,
				                "dates": {
				                    "startDate": null,
				                    "completionDate": "2019-01-01",
				                    "isCurrent": false
				                }
				            },
				            {
				                "id": 4843197,
				                "organization": "Colégio Professor Luiz Martinez",
				                "accreditation": {
				                    "education": "Técnico, Informática",
				                    "educationLevel": null,
				                    "inputStr": "Técnico, Informática",
				                    "matchStr": ""
				                },
				                "grade": null,
				                "location": null,
				                "dates": {
				                    "startDate": "2016-01-01",
				                    "completionDate": "2018-01-01",
				                    "isCurrent": false
				                }
				            }
				        ],
				        "emails": [
				            "thiagowlian@outlook.com.br"
				        ],
				        "location": {
				            "formatted": "São Paulo, State of São Paulo, Brazil",
				            "streetNumber": null,
				            "street": null,
				            "apartmentNumber": null,
				            "city": "São Paulo",
				            "postalCode": null,
				            "state": "State of São Paulo",
				            "country": "Brazil",
				            "rawInput": "Paulo, São Paulo, Patriarca",
				            "countryCode": "BR"
				        },
				        "name": {
				            "raw": "Thiago Cordeiro WlianSão",
				            "last": "Wliansão",
				            "first": "Thiago",
				            "title": "",
				            "middle": "Cordeiro"
				        },
				        "objective": "",
				        "phoneNumbers": [
				            "+5511932329303"
				        ],
				        "publications": [],
				        "referees": [],
				        "sections": [
				            {
				                "sectionType": "PersonalDetails",
				                "bbox": [
				                    68.57855,
				                    74.093506,
				                    365.21936,
				                    146.67786
				                ],
				                "pageIndex": 0,
				                "text": "Thiago Cordeiro WlianSão Paulo, São Paulo, Patriarca thiagowlian@outlook.com.br, (11) 93232-9303 https://github.com/ThiagoWlian"
				            },
				            {
				                "sectionType": "Summary",
				                "bbox": [
				                    68.57855,
				                    166.34534,
				                    521.02185,
				                    254.17426
				                ],
				                "pageIndex": 0,
				                "text": "Resumo Pessoal Atualmente estou estudando sobre o desenvolvimento de aplicações web com Java e tentando aplicar as melhores práticas que venho obtendo lendo livros e fazendo cursos. Meu objetivo é obter uma vaga em desenvolvimento web com Java e me aperfeiçoar cada vez mais como profissional."
				            },
				            {
				                "sectionType": "Skills/Interests/Languages",
				                "bbox": [
				                    68.99808,
				                    277.7353,
				                    267.25906,
				                    540.4478
				                ],
				                "pageIndex": 0,
				                "text": "Habilidades e Tecnologias • Java • Spring MVC • Spring Validation • Spring Data JPA • SQL • MySQL • HTML e CSS •C# • Windows Forms • Docker • Hibernate • Maven • Git • Inglês (Básico)"
				            },
				            {
				                "sectionType": "WorkExperience",
				                "bbox": [
				                    68.57855,
				                    563.56274,
				                    365.29865,
				                    671.27783
				                ],
				                "pageIndex": 0,
				                "text": "Experiência 08/2022 – Atual Desenvolvedor Java, Tecsinapse Criação e manutenção de funcionalidades em Web Services. Tecnologias: Java, Hibernate, JSF, Spring, Docker, Git"
				            },
				            {
				                "sectionType": "WorkExperience",
				                "bbox": [
				                    68.57855,
				                    70.58356,
				                    525.32074,
				                    425.64877
				                ],
				                "pageIndex": 1,
				                "text": "04/2020 – 06/2021 Assistente de suporte de TI, Engineering Brasil Atuei principalmente nas áreas de observabilidade e automação na infraestrutura de diversos clientes, sempre seguindo as boas práticas de mercado. As minhas principais atividades foram: - Gerenciamento de clusters de Docker Swarm. - Implementação e gerenciamento do Zabbix. - Criação de dashboards no Grafana. - Desenvolvimento de shell scripts para monitoramento e gerenciamento de recursos da infraestrutura. - Criação de automações com Ansible para uma eventual recuperação de um desastre dentro do ambiente do cliente. - Resolução de problemas de recursos da infraestrutura (memória, processamento, armazenamento). Todos as atividades foram realizadas utilizando a metodologia Scrum. Tecnologias: Git, Grafana, Docker, Docker Swarm, Zabbix, Ansible, Shell Script, Python, CentOS."
				            },
				            {
				                "sectionType": "Education",
				                "bbox": [
				                    68.57855,
				                    451.20715,
				                    350.7058,
				                    583.3219
				                ],
				                "pageIndex": 1,
				                "text": "Formação 2019 – Previsão para 12/2022 Faculdade de Informática e Administração Paulista (FIAP) Bacharelado, Sistemas de Informação 2016 – 2018 Colégio Professor Luiz Martinez Técnico, Informática"
				            },
				            {
				                "sectionType": "Footer",
				                "bbox": [
				                    68.71104,
				                    771.0149,
				                    74.02128,
				                    778.77606
				                ],
				                "pageIndex": 1,
				                "text": "2"
				            }
				        ],
				        "skills": [
				            {
				                "id": 52551451,
				                "emsiId": "KSKOWPG0Z69JH6T9DKIP",
				                "name": "Sobre",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551452,
				                "emsiId": "KSALSL0U9E60WLJXI7B7",
				                "name": "Grafana",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551453,
				                "emsiId": "KS7G0C36YW29VS8KPC05",
				                "name": "Script",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551454,
				                "emsiId": "KS126QY605N7YVHFYCTW",
				                "name": "MySQL",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551455,
				                "emsiId": "KS120JZ70YBB7DWH3SGT",
				                "name": "Recursos",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551456,
				                "emsiId": "KS440RX75WV25M3CJKLM",
				                "name": "Resolução",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551457,
				                "emsiId": "KSWLG35QHWN8HEW26PAB",
				                "name": "Java",
				                "lastUsed": "2022-08-01",
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    }
				                ]
				            },
				            {
				                "id": 52551458,
				                "emsiId": "KS122Z36QK3N5097B5JH",
				                "name": "Desenvolvimento web",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551459,
				                "emsiId": "KS120L16S3RLJ82VQ08H",
				                "name": "Desenvolvimento de aplicações",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "soft_skill",
				                "sources": [
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551460,
				                "emsiId": "KS26BVAZEM0MFCVFST66",
				                "name": "Ansible",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551461,
				                "emsiId": "KS4412Y6WH497DSJSGTV",
				                "name": "Suporte",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551462,
				                "emsiId": "KS442965X7Q6B5DSKGSC",
				                "name": "Zabbix",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551463,
				                "emsiId": "KS120SQ5W4Q57JMD2Y81",
				                "name": "Automação",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551464,
				                "emsiId": "KS440JQ6CH2PLBZVTYLV",
				                "name": "Shell Script",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551465,
				                "emsiId": "KS121KB68PWHRPJCJKQJ",
				                "name": "CentOS",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551466,
				                "emsiId": "KS1218W78FGVPVP2KXPX",
				                "name": "Gerenciamento",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "soft_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551467,
				                "emsiId": "KSY4WFI1S164RQUBSPCC",
				                "name": "Docker (Software)",
				                "lastUsed": "2022-08-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551468,
				                "emsiId": "KS120265WKHSMJ6HYX8P",
				                "name": "Microsoft Windows",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "soft_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551469,
				                "emsiId": "KS124PR62MV42B5C9S9F",
				                "name": "Hibernate (Java)",
				                "lastUsed": "2022-08-01",
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    }
				                ]
				            },
				            {
				                "id": 52551470,
				                "emsiId": "KS125LS6N7WP4S6SFTCK",
				                "name": "Python (Programming Language)",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551471,
				                "emsiId": "KS1200364C9C1LK3V5Q1",
				                "name": "C (Programming Language)",
				                "lastUsed": "2022-08-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "PersonalDetails",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551472,
				                "emsiId": "KS4423576TCS5W83BSV8",
				                "name": "Windows Forms",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551473,
				                "emsiId": "KS120076FGP5WGWYMP0F",
				                "name": "Java (Programming Language)",
				                "lastUsed": "2022-08-01",
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "Summary",
				                        "position": null,
				                        "workExperienceId": null
				                    },
				                    {
				                        "section": "WorkExperience",
				                        "position": 0,
				                        "workExperienceId": 9436752
				                    }
				                ]
				            },
				            {
				                "id": 52551474,
				                "emsiId": "KS98FOOTUROMAWNASKVR",
				                "name": "Docker Swarm",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551475,
				                "emsiId": "KS121F45VPV8C9W3QFYH",
				                "name": "Cascading Style Sheets (CSS)",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551476,
				                "emsiId": "ESCDCFECA9D9CC5AA7A3",
				                "name": "National Airspace System (NAS)",
				                "lastUsed": "2021-06-01",
				                "numberOfMonths": 14,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "WorkExperience",
				                        "position": 1,
				                        "workExperienceId": 9436753
				                    }
				                ]
				            },
				            {
				                "id": 52551477,
				                "emsiId": "KS440W865GC4VRBW6LJP",
				                "name": "SQL (Programming Language)",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            },
				            {
				                "id": 52551478,
				                "emsiId": "KS1200578T5QCYT0Z98G",
				                "name": "HyperText Markup Language (HTML)",
				                "lastUsed": null,
				                "numberOfMonths": null,
				                "type": "hard_skill",
				                "sources": [
				                    {
				                        "section": "Skills/Interests/Languages",
				                        "position": null,
				                        "workExperienceId": null
				                    }
				                ]
				            }
				        ],
				        "languages": [
				            "Portuguese"
				        ],
				        "summary": "Atualmente estou estudando sobre o desenvolvimento de aplicações web com Java e tentando aplicar as melhores práticas que venho obtendo lendo livros e fazendo cursos. Meu objetivo é obter uma vaga em desenvolvimento web com Java e me aperfeiçoar cada vez mais como profissional.",
				        "websites": [
				            "https://github.com/thiagowlian"
				        ],
				        "linkedin": null,
				        "totalYearsExperience": 2,
				        "profession": "Técnico de Suporte",
				        "workExperience": [
				            {
				                "id": 9436752,
				                "jobTitle": "Desenvolvedor Java",
				                "organization": "Tecsinapse",
				                "location": null,
				                "dates": {
				                    "startDate": null,
				                    "endDate": "2022-08-01",
				                    "monthsInPosition": null,
				                    "isCurrent": false
				                },
				                "jobDescription": "Criação e manutenção de funcionalidades em Web Services. Tecnologias: Java, Hibernate, JSF, Spring, Docker, Git ",
				                "occupation": {
				                    "jobTitle": "Desenvolvedor Java",
				                    "jobTitleNormalized": null,
				                    "classification": null,
				                    "managementLevel": null
				                }
				            },
				            {
				                "id": 9436753,
				                "jobTitle": "Assistente de suporte de TI",
				                "organization": "Engineering Brasil",
				                "location": null,
				                "dates": {
				                    "startDate": "2020-04-01",
				                    "endDate": "2021-06-01",
				                    "monthsInPosition": 14,
				                    "isCurrent": false
				                },
				                "jobDescription": "Atuei principalmente nas áreas de observabilidade e automação na infraestrutura de diversos clientes, sempre seguindo as boas práticas de mercado. As minhas principais atividades foram: \n-Gerenciamento de clusters de Docker Swarm. \n-Implementação e gerenciamento do Zabbix. \n-Criação de dashboards no Grafana. \n-Desenvolvimento de shell scripts para monitoramento e gerenciamento de recursos da infraestrutura. \n-Criação de automações com Ansible para uma eventual recuperação de um desastre dentro do ambiente do cliente. \n-Resolução de problemas de recursos da infraestrutura (memória, processamento, armazenamento). Todos as atividades foram realizadas utilizando a metodologia Scrum. Tecnologias: Git, Grafana, Docker, Docker Swarm, Zabbix, Ansible, Shell Script, Python, CentOS. ",
				                "occupation": {
				                    "jobTitle": "Assistente de suporte de TI",
				                    "jobTitleNormalized": "DE Underwriter",
				                    "classification": {
				                        "socCode": 4129,
				                        "title": "Financial administrative occupations n.e.c.",
				                        "minorGroup": "Administrative Occupations: Finance",
				                        "subMajorGroup": "ADMINISTRATIVE OCCUPATIONS",
				                        "majorGroup": "ADMINISTRATIVE AND SECRETARIAL OCCUPATIONS"
				                    },
				                    "managementLevel": "Low"
				                }
				            }
				        ],
				        "headShot": null,
				        "isResumeProbability": 77,
				        "rawText": "Thiago Cordeiro WlianSão Paulo, São Paulo, Patriarca thiagowlian@outlook.com.br, (11) 93232-9303 https://github.com/ThiagoWlian\nResumo Pessoal Atualmente estou estudando sobre o desenvolvimento de aplicações web com Java e tentando aplicar as melhores práticas que venho obtendo lendo livros e fazendo cursos. Meu objetivo é obter uma vaga em desenvolvimento web com Java e me aperfeiçoar cada vez mais como profissional.\nHabilidades e Tecnologias • Java • Spring MVC • Spring Validation • Spring Data JPA • SQL • MySQL • HTML e CSS •C# • Windows Forms • Docker • Hibernate • Maven • Git • Inglês (Básico)\nExperiência 08/2022 – Atual Desenvolvedor Java, Tecsinapse Criação e manutenção de funcionalidades em Web Services. Tecnologias: Java, Hibernate, JSF, Spring, Docker, Git\n04/2020 – 06/2021 Assistente de suporte de TI, Engineering Brasil Atuei principalmente nas áreas de observabilidade e automação na infraestrutura de diversos clientes, sempre seguindo as boas práticas de mercado. As minhas principais atividades foram: - Gerenciamento de clusters de Docker Swarm. - Implementação e gerenciamento do Zabbix. - Criação de dashboards no Grafana. - Desenvolvimento de shell scripts para monitoramento e gerenciamento de recursos da infraestrutura. - Criação de automações com Ansible para uma eventual recuperação de um desastre dentro do ambiente do cliente. - Resolução de problemas de recursos da infraestrutura (memória, processamento, armazenamento). Todos as atividades foram realizadas utilizando a metodologia Scrum. Tecnologias: Git, Grafana, Docker, Docker Swarm, Zabbix, Ansible, Shell Script, Python, CentOS.\nFormação 2019 – Previsão para 12/2022 Faculdade de Informática e Administração Paulista (FIAP) Bacharelado, Sistemas de Informação 2016 – 2018 Colégio Professor Luiz Martinez Técnico, Informática\n2"
				    },
				    "meta": {
				        "identifier": "ImZqfjyz",
				        "ready": true,
				        "failed": false,
				        "readyDt": "2022-09-19T01:36:00.695613Z",
				        "fileName": "CurrículoThiagoWlian.pdf",
				        "expiryTime": null,
				        "language": "pt",
				        "pdf": "https://affinda-api.s3.amazonaws.com/media/documents/Curr%C3%ADculoThiagoWlian_kH308jL.pdf?AWSAccessKeyId=ASIAU2V7FN3BVMWWN3GL&Signature=ZTWTEBcmhEUkVd2i%2BJlPAtCKGtk%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEJD%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDmFwLXNvdXRoZWFzdC0yIkcwRQIhAPf%2F74dmUsGOP9v2qUDxQd8uLkE8wT0zXDULPlJ15QcQAiAnIA00EW0TuciRJDFfvZX%2FnFURjoBvcRwRpg%2FARnnLjyruAwg5EAAaDDMzMjE4NzEzNTY4MyIMr%2BKL%2F2MnCLFCnI5BKssDueY%2FQjR6WrYgCllMAIqA1ljjSiRWaXwhSaPbprHSvvEizb3WLfCczDqDPxHXTMb6hYzNkGmrj25GqfWPqsydEEpfz5EyqqAOejG%2BR29HSdUhqihzLBJ4is5w3Z4aVyG%2F3l8s0PXbNey0vbBWsLxyvp%2FZ%2FiGf9yfhLYRp8jF4BhR0zd5iSjwVgKCb6rFSYgAR46280m4wNtDiuHqIVpZAO4Z1MLsD4F0pci2fCWsqLNvE1%2FH4vdw9GCQnDzAHAaVnMXT4gk28PspFPwKMlRVrGHFKbpNO3XLkrdFJM6NJ15xjxLTVoKskfle4Icy81JCdyIhkpyLkqSO6ovtcEd3j6fO2iIPF6ulD1xnOPp%2BngxDR9Dzy3eyheED35EOAzoo54OyuWZscW7Xp4o5VkiiOgFLi8CAo6MgNSpU3dzzIGfQGD6nU3W6tBpOxQqsoDWgKLPQuqb1rezuw%2F8RxInGWdBAYSohkVmhPhhflIJvFKi5DZICzNy4dC9pVG02ytQl5j4smZO65Sz1ZVomZDAjEHX1RzJ72PaOoaw%2Fv2Mnx05XIiis7rIlQn2sUy9doPvbYhF%2F9OqNMJ3QoAIwKR9m4W1CfA4D5IWP69exbMNTknpkGOqUBeG6WUWputXDlOwrVNQqRD2XHMe%2FYUmFFheBl%2FyBBl0%2B3kmvLzLjf1cPJGK3PUcc7p%2FEtSWTMATCrB01Mw6ALKDvo0ZAzEDIJiW2b7ckQZ3ge5E3o50E5IsPpa2egMTtuPkLOcqmEA89FIPq1XEI%2B5C6M9IIteuzfF%2Fz74IflEt16kLieJPofSYHL102hypJkG%2B5J5OJO%2BUUh3HoHJRsWynZnudFU&Expires=1663554960",
				        "splittedFrom": null,
				        "splittedTo": [],
				        "pages": [
				            {
				                "id": 5926750,
				                "pageIndex": 0,
				                "image": null,
				                "height": 841.9200439453125,
				                "width": 595.3200073242188,
				                "rotation": 0
				            },
				            {
				                "id": 5926751,
				                "pageIndex": 1,
				                "image": null,
				                "height": 841.9200439453125,
				                "width": 595.3200073242188,
				                "rotation": 0
				            }
				        ]
				    },
				    "error": {
				        "errorCode": null,
				        "errorDetail": null
				    }
				}
			""";


		Data data = curriculoService.converteJsonEmObjeto(json);
		CurriculoModel curriculoModel = new CurriculoModel();
		curriculoModel.setExperiencias(data.getData().converteParaExperienciaModel());
		curriculoModel.setFormacoes(data.getData().converteParaFormacoesModel());
		curriculoModel.setHabilidades(data.getData().converteParaHabilidadesModel());
		curriculoModel.setCandidato(candidatoCadastrado);
		curriculoService.criarNovoCurriculo(curriculoModel);

		return "cadastroInicial";
	}
}
