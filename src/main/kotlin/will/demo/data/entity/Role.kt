package will.demo.data.entity

import jakarta.persistence.*
import zygarde.codegen.ZyModel

@Table(schema = "public", name = "roles")
@ZyModel
@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    val name: String,

    val description: String? = null,

    val available: Boolean? = null,

    @Column(name = "project_id")
    val projectId: Int? = null
)
