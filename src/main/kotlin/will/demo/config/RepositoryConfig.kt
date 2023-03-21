package will.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import zygarde.data.jpa.dao.ZygardeJpaRepository

@Configuration
@EnableJpaRepositories(
    basePackages = ["will.demo.data.dao"],
    repositoryBaseClass = ZygardeJpaRepository::class
)
class RepositoryConfig
