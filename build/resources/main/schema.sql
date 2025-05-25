CREATE TABLE `produto` (
    `produto_id` INT NOT NULL AUTO_INCREMENT,
    `produto` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`produto_id`)
);

CREATE TABLE `dimensao` (
    `dimensao_id` INT NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    `altura` INT NOT NULL,
    `largura` INT NOT NULL,
    `comprimento` INT NOT NULL,
    PRIMARY KEY (`dimensao_id`)
);

CREATE TABLE `caixa` (
    `caixa_id` INT NOT NULL AUTO_INCREMENT,
    `produto_id` INT NOT NULL,
    `observacoes` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`caixa_id`)
);

ALTER TABLE `caixa`
ADD CONSTRAINT `Caixa_ProdutoFK`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

CREATE TABLE `pedido` (
    `pedido_id` INT NOT NULL AUTO_INCREMENT,
    `produto_id` INT NOT NULL,
    `dimensao_id` INT NOT NULL,
    PRIMARY KEY (`pedido_id`)
);

ALTER TABLE `pedido`
ADD CONSTRAINT `Pedido_ProdutoFK`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE `pedido`
ADD CONSTRAINT `Pedido_DimensaoFK`
    FOREIGN KEY (`dimensao_id`)
    REFERENCES `dimensao` (`dimensao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;