-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2022 a las 11:48:14
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alcaldia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades_contrato`
--

CREATE TABLE `actividades_contrato` (
  `id_actividades_contrato` int(10) UNSIGNED NOT NULL,
  `id_contratos` int(11) UNSIGNED NOT NULL,
  `indicador_de_resultado` varchar(45) NOT NULL,
  `nombre_actividad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `actividades_contrato`
--

INSERT INTO `actividades_contrato` (`id_actividades_contrato`, `id_contratos`, `indicador_de_resultado`, `nombre_actividad`) VALUES
(9, 8, 'bien', 'laboral'),
(10, 9, 'sdfd', 'prestaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(10) UNSIGNED NOT NULL,
  `cargo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `cargo`) VALUES
(8, 'Despacho del alcalde'),
(9, 'Secretaría de Gobierno'),
(10, 'Secretaría de Hacienda'),
(11, 'Secretaría de Educación');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(10) UNSIGNED NOT NULL,
  `categoria_documento` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `categoria_documento`) VALUES
(7, 'buena'),
(8, 'Regular'),
(9, 'sss');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `id_contratos` int(10) UNSIGNED NOT NULL,
  `objeto` varchar(45) NOT NULL,
  `valor` varchar(45) NOT NULL,
  `secretaria` varchar(45) NOT NULL,
  `ano_de_contrato` int(10) UNSIGNED NOT NULL,
  `cdp` varchar(45) NOT NULL,
  `rp` varchar(45) NOT NULL,
  `id_persona` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`id_contratos`, `objeto`, `valor`, `secretaria`, `ano_de_contrato`, `cdp`, `rp`, `id_persona`) VALUES
(8, 'elementos de aseo', '10000', 'oficina 2', 2, 'si', 'si', 4),
(9, 'elementos', '2000', ' 2', 2, 'si', 'si', 4),
(10, 'juan', '44', 'numero 1', 4, 'si', 'si', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evidencia`
--

CREATE TABLE `evidencia` (
  `id_evidencia` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `imagen` varchar(250) NOT NULL,
  `fecha_cargue` date NOT NULL,
  `estado` varchar(45) NOT NULL,
  `id_actividades_contrato` int(11) UNSIGNED NOT NULL,
  `id_prueba` int(11) UNSIGNED NOT NULL,
  `id_persona_carga` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `evidencia`
--

INSERT INTO `evidencia` (`id_evidencia`, `nombre`, `descripcion`, `imagen`, `fecha_cargue`, `estado`, `id_actividades_contrato`, `id_prueba`, `id_persona_carga`) VALUES
(33, 'rwe', 'ewe', 'rwe.png', '2022-09-13', 'w', 9, 16, 4),
(34, 'rwe', 'ewe', 'huu.png', '2022-09-13', 'w', 9, 16, 4),
(41, 'ssssssssssa', 'aaaaaa', 'saaaa.png', '2022-09-13', 'aaa', 9, 16, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(10) UNSIGNED NOT NULL,
  `ano` varchar(10) NOT NULL,
  `id_persona` int(11) UNSIGNED NOT NULL,
  `id_cargo` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `ano`, `id_persona`, `id_cargo`) VALUES
(9, '2', 4, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficina`
--

CREATE TABLE `oficina` (
  `id_oficina` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_secretaria` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `oficina`
--

INSERT INTO `oficina` (`id_oficina`, `nombre`, `id_secretaria`) VALUES
(8, 'central ', 29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `id_permisos` int(10) UNSIGNED NOT NULL,
  `id_rol` int(11) UNSIGNED NOT NULL,
  `url` varchar(100) NOT NULL,
  `create` tinyint(1) NOT NULL DEFAULT 0,
  `read` tinyint(1) NOT NULL DEFAULT 0,
  `update` tinyint(1) NOT NULL DEFAULT 0,
  `delete` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id_permisos`, `id_rol`, `url`, `create`, `read`, `update`, `delete`) VALUES
(25, 6, '/list-cargo', 1, 1, 1, 1),
(27, 7, '/list-cargo', 1, 1, 0, 0),
(28, 6, '/list-evidencia', 1, 1, 1, 1),
(29, 7, '/list-evidencia', 1, 1, 0, 0),
(30, 6, '/list-persona', 1, 1, 0, 1),
(31, 7, '/list-persona', 1, 1, 0, 0),
(32, 6, '/list-contratos', 1, 1, 1, 1),
(33, 7, '/list-contratos', 1, 1, 0, 0),
(34, 6, '/list-actividades_contrato', 1, 1, 1, 1),
(35, 7, '/list-actividades_contrato', 1, 1, 0, 0),
(36, 6, '/list-categoria', 1, 1, 1, 1),
(37, 7, '/list-categoria', 1, 1, 0, 0),
(38, 6, '/list-secretaria', 1, 1, 1, 1),
(39, 7, '/list-secretaria', 1, 1, 0, 0),
(40, 6, '/list-tipo_documento', 1, 1, 1, 1),
(41, 7, '/list-tipo_documento', 1, 1, 0, 0),
(42, 6, '/list-prueba', 1, 1, 1, 1),
(43, 7, '/list-prueba', 1, 1, 0, 0),
(44, 6, '/list-oficina', 1, 1, 1, 1),
(45, 7, '/list-oficina', 1, 1, 0, 0),
(46, 6, 'list-permisos', 1, 1, 1, 1),
(47, 7, 'list-permisos', 1, 1, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(10) UNSIGNED NOT NULL,
  `documento` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `id_cargo` int(11) UNSIGNED NOT NULL,
  `id_rol` int(11) UNSIGNED NOT NULL,
  `id_carga_persona` int(11) UNSIGNED NOT NULL,
  `id_tipo_documento` int(11) DEFAULT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `documento`, `nombre`, `apellido`, `sexo`, `telefono`, `correo`, `id_cargo`, `id_rol`, `id_carga_persona`, `id_tipo_documento`, `password`) VALUES
(4, 1077480940, 'juan', 'palacios', 'maculino', '3116770929', 'admin@gmail.com', 8, 6, 5, 77, '123'),
(5, 1077480949, 'estiwar', 'palacios', 'maculino', '3188929902', 'funcionario@gmail.com', 9, 7, 5, 77, '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_carga`
--

CREATE TABLE `persona_carga` (
  `id_persona_carga` int(10) UNSIGNED NOT NULL,
  `carga` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona_carga`
--

INSERT INTO `persona_carga` (`id_persona_carga`, `carga`) VALUES
(4, 'documentos'),
(5, 'BIENESTAR SOCIAL'),
(6, 'documentos de la actividad realizada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE `prueba` (
  `id_prueba` int(11) UNSIGNED NOT NULL,
  `prueba` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prueba`
--

INSERT INTO `prueba` (`id_prueba`, `prueba`) VALUES
(16, 'fotos-actividad'),
(17, 'Documento-Informes'),
(18, 'Videos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre`) VALUES
(6, 'administrador'),
(7, 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretaria`
--

CREATE TABLE `secretaria` (
  `id_secretaria` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_contratos` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `secretaria`
--

INSERT INTO `secretaria` (`id_secretaria`, `nombre`, `id_contratos`) VALUES
(29, 'marlon', 8),
(30, 'sdfd', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_documentos_contractos`
--

CREATE TABLE `tb_documentos_contractos` (
  `id_tb_documentos_contractos` int(10) UNSIGNED NOT NULL,
  `fecha_cargue` date NOT NULL,
  `archivo_ruta` varchar(45) NOT NULL,
  `id_categoria` int(11) UNSIGNED NOT NULL,
  `id_persona` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tb_documentos_contractos`
--

INSERT INTO `tb_documentos_contractos` (`id_tb_documentos_contractos`, `fecha_cargue`, `archivo_ruta`, `id_categoria`, `id_persona`) VALUES
(9, '2022-06-01', 'rural', 8, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `id_tipo_documento` int(11) NOT NULL,
  `tipo_documento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`id_tipo_documento`, `tipo_documento`) VALUES
(77, 'Cedula.ciudadana'),
(78, 'Cedula.extranjeria'),
(80, 'saas'),
(79, 'Tarjeta Identidad');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades_contrato`
--
ALTER TABLE `actividades_contrato`
  ADD PRIMARY KEY (`id_actividades_contrato`),
  ADD KEY `id_contratos_contratos` (`id_contratos`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`id_contratos`),
  ADD KEY `id_persona_fk` (`id_persona`);

--
-- Indices de la tabla `evidencia`
--
ALTER TABLE `evidencia`
  ADD PRIMARY KEY (`id_evidencia`),
  ADD KEY `id_actividades_contrato` (`id_actividades_contrato`),
  ADD KEY `id_persona_carga` (`id_persona_carga`),
  ADD KEY `id_prueba` (`id_prueba`);

--
-- Indices de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`),
  ADD KEY `id_persona` (`id_persona`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `oficina`
--
ALTER TABLE `oficina`
  ADD PRIMARY KEY (`id_oficina`),
  ADD KEY `id_secretaria` (`id_secretaria`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id_permisos`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD KEY `persona_ibfk_3_idx` (`id_tipo_documento`),
  ADD KEY `persona_ibfk_1` (`id_cargo`),
  ADD KEY `persona_ibfk_2` (`id_rol`),
  ADD KEY `persona_ibfk_3` (`id_carga_persona`);

--
-- Indices de la tabla `persona_carga`
--
ALTER TABLE `persona_carga`
  ADD PRIMARY KEY (`id_persona_carga`);

--
-- Indices de la tabla `prueba`
--
ALTER TABLE `prueba`
  ADD PRIMARY KEY (`id_prueba`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`id_secretaria`),
  ADD KEY `id_contratos` (`id_contratos`);

--
-- Indices de la tabla `tb_documentos_contractos`
--
ALTER TABLE `tb_documentos_contractos`
  ADD PRIMARY KEY (`id_tb_documentos_contractos`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_persona` (`id_persona`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id_tipo_documento`),
  ADD UNIQUE KEY `tipo_documento_UNIQUE` (`tipo_documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades_contrato`
--
ALTER TABLE `actividades_contrato`
  MODIFY `id_actividades_contrato` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `contratos`
--
ALTER TABLE `contratos`
  MODIFY `id_contratos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `evidencia`
--
ALTER TABLE `evidencia`
  MODIFY `id_evidencia` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id_funcionario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `oficina`
--
ALTER TABLE `oficina`
  MODIFY `id_oficina` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `id_permisos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `persona_carga`
--
ALTER TABLE `persona_carga`
  MODIFY `id_persona_carga` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `prueba`
--
ALTER TABLE `prueba`
  MODIFY `id_prueba` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  MODIFY `id_secretaria` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `tb_documentos_contractos`
--
ALTER TABLE `tb_documentos_contractos`
  MODIFY `id_tb_documentos_contractos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades_contrato`
--
ALTER TABLE `actividades_contrato`
  ADD CONSTRAINT `actividades_contrato_ibfk_1` FOREIGN KEY (`id_contratos`) REFERENCES `contratos` (`id_contratos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD CONSTRAINT `persona_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `evidencia`
--
ALTER TABLE `evidencia`
  ADD CONSTRAINT `evidencia_ibfk_1` FOREIGN KEY (`id_actividades_contrato`) REFERENCES `actividades_contrato` (`id_actividades_contrato`),
  ADD CONSTRAINT `evidencia_ibfk_2` FOREIGN KEY (`id_persona_carga`) REFERENCES `persona_carga` (`id_persona_carga`),
  ADD CONSTRAINT `evidencia_ibfk_3` FOREIGN KEY (`id_prueba`) REFERENCES `prueba` (`id_prueba`);

--
-- Filtros para la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `id_cargo_fk2` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
  ADD CONSTRAINT `id_persona_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `oficina`
--
ALTER TABLE `oficina`
  ADD CONSTRAINT `id_secretaria_fk` FOREIGN KEY (`id_secretaria`) REFERENCES `secretaria` (`id_secretaria`);

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `id_rol_fk1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `id_carga_persona_fk3` FOREIGN KEY (`id_carga_persona`) REFERENCES `persona_carga` (`id_persona_carga`),
  ADD CONSTRAINT `id_cargo` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
  ADD CONSTRAINT `id_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  ADD CONSTRAINT `id_tipo_documento_fk4` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`);

--
-- Filtros para la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD CONSTRAINT `secretaria_ibfk_1` FOREIGN KEY (`id_contratos`) REFERENCES `contratos` (`id_contratos`);

--
-- Filtros para la tabla `tb_documentos_contractos`
--
ALTER TABLE `tb_documentos_contractos`
  ADD CONSTRAINT `id_categoria_fk2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `id_persona_fk1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
