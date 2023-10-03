// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

//Nivel de cada formação
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

//Classe com informações sobre os usuários
class Usuario(private val nome: String){
    //Lista de formações do usuário
    private val formacoes: MutableSet<String> = mutableSetOf()
    //Lista de cursos que o usuário está matrículado atualmente
    private val cursando: MutableList<String> = mutableListOf()
    fun addCurso(curso: String){
        cursando.add(curso)
    }

    fun addFormacao(formacao: String){
        formacoes.add(formacao)
    }

    override fun toString(): String {
        return "Usuario{\n" +
                "\tnome='$nome', \n" +
                "\tformacoes=$formacoes, \n" +
                "\tcursando=$cursando\n}"
    }

}

//Descrição do conteudo de uma formação
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)


class Formacao(
    private val nome: String,
    private val nivel: Nivel,
    private val conteudos: List<ConteudoEducacional>,
    ) {
    //Lista de alunos inscritos
    private val inscritos: MutableSet<Usuario> = mutableSetOf()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        conteudos.forEach {
            usuario.addCurso(it.nome)
        }
        usuario.addFormacao(this.descricao())
    }

    private fun descricao(): String{
        return "Formacao{nome=$nome, nivel=$nivel}"
    }
    override fun toString(): String {
        return "Formacao{\n\tnome='$nome', \n" +
                "\tnivel=$nivel, \n" +
                "\tconteudos=$conteudos, \n" +
                "\tinscritos=$inscritos\n}\n"
    }
}

fun createFormacoes(): MutableMap<String, Formacao>{
    return mutableMapOf(
        "Back-end Developer" to
        Formacao(
            "Back-end Developer",
            Nivel.DIFICIL,
            listOf(
                ConteudoEducacional("Curso Java Developer", 240),
                ConteudoEducacional("Curso .NET Developer", 180),
                ConteudoEducacional("Curso Python Developer", 180),
                ConteudoEducacional("Curso TypeScript Fullstack Developer", 240),
                ConteudoEducacional("Curso PHP Developer", 180),
                ConteudoEducacional("Curso Golang Developer", 180),
                ConteudoEducacional("Curso Programação Rativa com Spring Webflux", 120),
                ConteudoEducacional("Curso C/C++ Developer", 240),
            )
        ),
        "Front-end Developer" to
        Formacao(
            "Front-end Developer",
            Nivel.INTERMEDIARIO,
            listOf(
                ConteudoEducacional("Curso UX Developer", 120),
                ConteudoEducacional("Curso HTML Developer", 60),
                ConteudoEducacional("Curso CSS Developer", 60),
                ConteudoEducacional("Curso JavaScript Developer", 120),
                ConteudoEducacional("Curso Angular Developer", 90),
                ConteudoEducacional("Curso React Developer", 120),
                ConteudoEducacional("Curso TypeScript Fullstack Developer", 240),
            )
        ),
        "Mobile Developer" to
        Formacao(
            "Mobile Developer",
            Nivel.DIFICIL,
            listOf(
                ConteudoEducacional("Curso Android Developer", 240),
                ConteudoEducacional("Curso Flutter Specialist", 280),
                ConteudoEducacional("Curso Swift & IOS Developer", 240),
                ConteudoEducacional("Curso IOS Developer", 280),
            )
        ),
        "DevOps Engineer" to
        Formacao(
            "DevOps Engineer",
            Nivel.INTERMEDIARIO,
            listOf(
                ConteudoEducacional("Curso DevOps Fundamentals", 90),
                ConteudoEducacional("Curso Linus", 120),
                ConteudoEducacional("Curso Docker Fundamentals", 90),
                ConteudoEducacional("Curso Kubernetes Fundamentals", 90),
                ConteudoEducacional("Curso Git CI/DC", 60),
                ConteudoEducacional("Curso Google Cloud Platform Specialist", 180),
                ConteudoEducacional("Curso AWS Cloud Practitioner Certification", 180),
                ConteudoEducacional("Curso Cybersecurity Specialist", 180),
            )
        ),
        "Game Developer" to
        Formacao(
            "Game Developer",
            Nivel.DIFICIL,
            listOf(
                ConteudoEducacional("Curso Programação Roblox", 240),
                ConteudoEducacional("Curso Unity 3D Game Developer", 300),
                ConteudoEducacional("Curso Lua Developer", 120),
            )
        ),
        "Blokchain Developer" to
        Formacao(
            "Blokchain Developer",
            Nivel.DIFICIL,
            listOf(
                ConteudoEducacional("Curso Blockchain Specialist", 240),
                ConteudoEducacional("Curso WEB3 Fundamentals", 180),
            )
        ),
        "Quality Assurance Analyst" to
        Formacao(
            "Quality Assurance Analyst",
            Nivel.BASICO,
            listOf(
                ConteudoEducacional("Curso Quality Assurance QA", 240),
            )
        ),
        "Low-code Developer" to
        Formacao(
            "Low-code Developer",
            Nivel.BASICO,
            listOf(
                ConteudoEducacional("Curso Microsoft Dynamics 365 CRM", 300),
                ConteudoEducacional("Curso OutSystems Fundamentals", 240),
            )
        ),
    )
}

fun main() {

    //O código cria uma lista de usuários que serão
    //mátriculados em vários cursos. Cada usuário.
    //pode se matricular em mais de um curso.

    val formacoes = createFormacoes()
    val usuarios = mutableListOf<Usuario>()
    val isaac = Usuario("Izac")
    usuarios.add(isaac)
    val maria = Usuario("Maria")
    usuarios.add(maria)
    val marcos = Usuario("Marcos")
    usuarios.add(marcos)
    val jose = Usuario("José")
    usuarios.add(jose)
    val talita = Usuario("Talita")
    usuarios.add(talita)
    val jessica = Usuario("Jéssica")
    usuarios.add(jessica)

    //Lista com todas as formações disponíveis juntamente
    //com todos os usuários inscritos em cada formação
    println("---------- Lista de formações ------------")
    println("------------------------------------------")
    println(formacoes)

    formacoes["Back-end Developer"]?.matricular(isaac)
    formacoes["DevOps Engineer"]?.matricular(isaac)
    formacoes["Game Developer"]?.matricular(isaac)
    formacoes["Mobile Developer"]?.matricular(isaac)

    formacoes["Front-end Developer"]?.matricular(maria)
    formacoes["Low-code Developer"]?.matricular(maria)
    formacoes["Mobile Developer"]?.matricular(maria)

    formacoes["Front-end Developer"]?.matricular(marcos)
    formacoes["Back-end Developer"]?.matricular(marcos)
    formacoes["Blokchain Developer"]?.matricular(marcos)

    formacoes["Low-code Developer"]?.matricular(jose)

    formacoes["Blokchain Developer"]?.matricular(talita)
    formacoes["Low-code Developer"]?.matricular(talita)

    formacoes["Quality Assurance Analyst"]?.matricular(jessica)
    formacoes["Front-end Developer"]?.matricular(jessica)

    //Lista todos os usuários, detalhando qual a formação
    //dos mesmo e qual cursos eles estão matriculados
    println("---------- Lista de Usuários ------------")
    println("------------------------------------------")
    usuarios.forEach { usuario ->
        println(usuario.toString())
    }

}
