# ProjetoIForum-backend

O Instituto Federal da Paraíba (IFPB), com sua ampla comunidade acadêmica, necessita de mecanismos claros e seguros para a gestão da participação e controle social. Atualmente, os canais de manifestação, embora existam, carecem de uma solução unificada que garanta o anonimato efetivo, a rastreabilidade do processo e a centralização das informações, fatores essenciais para fomentar a confiança e a transparência na gestão.

Portanto, o desenvolvimento do sistema IFórum justifica-se pela urgência em estabelecer uma plataforma digital, única e robusta, que não apenas simplifique o registro de denúncias e sugestões, mas que também assegure o sigilo e a eficiência no tratamento dessas informações. O IFórum é essencial para fortalecer a cultura de paz, transparência e participação dentro do IFPB, transformando manifestações em ações concretas de melhoria e responsabilidade institucional.

O IFórum é um Sistema de Gestão de Manifestações desenvolvido para a comunidade do IFPB, visando modernizar e centralizar o recebimento, a triagem e o acompanhamento de denúncias, sugestões, elogios e solicitações. A plataforma opera como uma ouvidoria digital, destacando-se pela garantia do anonimato seguro para o manifestante e pela provisão de ferramentas gerenciais robustas para os setores responsáveis (Ouvidoria, Corregedoria), transformando o feedback da comunidade em dados acionáveis e rastreáveis.

Atores envolvidos
Membro (Denunciante/Sugestor): Aluno, professor ou técnico administrativo do IFPB. Seu papel é registrar manifestações (denúncias, sugestões, elogios) e acompanhar o status via protocolo.
Setor Responsável (Investigador): Servidores da Corregedoria, Ouvidoria ou outros setores (ex: TI, Infraestrutura) que recebem a manifestação encaminhada. Seu papel é analisar, tomar providências e dar a resposta final ao sistema
Administrador do Sistema (Ouvidoria): Servidor responsável pela gestão do IFórum. Seu papel é triar as manifestações, encaminhar aos setores corretos, gerar relatórios e gerenciar cadastros de usuários e categorias.

RF01 – Autenticação: O sistema deve permitir que o usuário (aluno, professor, técnico) acesse a plataforma utilizando suas credenciais institucionais (login e senha do IFPB).
RF02 – Registro de Manifestação: O sistema deve permitir o preenchimento de um formulário para registrar novos tipos de manifestação, como: Denúncia, Reclamação, Sugestão, Elogio ou Solicitação.
RF03 – Anonimato Seguro: O sistema deve oferecer a opção de registro anônimo para o tipo "Denúncia", garantindo que a identidade do manifestante não seja armazenada nem revelada, conforme a legislação de ouvidoria.
RF04 – Identificação Sigilosa: Caso o manifestante opte por se identificar, o sistema deve garantir o sigilo total de seus dados pessoais para o público e para a área de apuração.
RF05 – Geração de Protocolo: Após o envio, o sistema deve gerar um número de protocolo único e intransferível para que o manifestante possa acompanhar o status de sua demanda.
RF06 – Anexar Evidências: O sistema deve permitir que o manifestante anexe arquivos (imagens, documentos, áudios) para complementar o relato, com limite de tamanho e tipo de arquivo definidos.
RF07 – Acompanhamento de Status: O sistema deve permitir ao manifestante consultar o status da sua manifestação, utilizando o número de protocolo (ex: "Em Triagem", "Em Análise", "Concluído").
RF08 – Complementação de Informação: O sistema deve permitir que o manifestante (identificado ou anônimo, por meio do protocolo) forneça informações adicionais após a submissão, caso solicitado pela Ouvidoria.
RF09 – Visualização da Resposta: O sistema deve apresentar a resposta conclusiva ou o parecer da Ouvidoria para o manifestante, mantendo um histórico de todas as interações.
RF10 – Visualização e Triagem: O sistema deve exibir uma lista de todas as manifestações recebidas, classificadas por tipo, data e status, permitindo à Ouvidoria priorizar a triagem.
RF11 – Registro de Ações: O sistema deve permitir que o Setor Responsável registre todas as ações tomadas durante o processo de apuração/análise, formando um histórico interno da manifestação
RF12 – Alteração de Status: O sistema deve permitir a alteração do status da manifestação (Ex: "Em Análise" para "Concluído" ou "Arquivado").

O desenvolvimento e a modelagem do sistema IFórum representam a concretização de uma solução robusta e essencial para o Instituto Federal da Paraíba (IFPB). O projeto cumpriu seu objetivo geral de estabelecer uma plataforma digital e segura para a gestão de manifestações (denúncias e sugestões), transformando o feedback da comunidade em um instrumento de controle e aprimoramento institucional.
Os requisitos funcionais detalhados asseguram que o sistema entregará funcionalidades críticas, como o registro anônimo e sigiloso (RF03, RNF06), a geração de protocolo único para rastreabilidade (RF05), e o controle de fluxo e prazos para a Ouvidoria (RF13). A modelagem (Diagramas de Caso de Uso e Requisitos) valida a viabilidade técnica da solução, demonstrando que o IFórum está pronto para ser implementado, respeitando as exigências de segurança, usabilidade e desempenho (RNF04, RNF08).
Em suma, o IFórum não é apenas um sistema de software; é um passo estratégico em direção a uma cultura de transparência e participação efetiva dentro do IFPB, contribuindo diretamente para a melhoria contínua da gestão e para o fortalecimento da confiança mútua entre a instituição e sua comunidade.


