# Crear prestadores

1. Hacer los scripts de sql de 
    social_reason
    company_social
    prestadores

2. Ejecucar el archivo GenerarSql para generar los sql de administrativos -> social_admin

3. Ejecucar el archivo GenerarSql para generar los sql de medicos -> social_medical

4. Ejecucar el archivo GenerarSql para generar los sql de liquidadores -> social_liquidator

5. Ejecutar los scripts de "social_reason, company_social, prestadores" en openkm

6. Ejecutar los scripts de "social_admin, social_medical, social_liquidator" en openkm

7. En openkm ejecutar CreateSocialReason.bsh y cambiar el perfil a razon social

8. Cambiar de perfil buscar por rol "RS0096" al perfil de RazonSocial

9. En openkm ejecutar CreatePrestadores.bsh y cambiar el perfil a prestadores

10. Cambiar de perfil buscar por id "30715332589" al perfil de Prestador

11. En openkm ejecutar UpdateAdmin y verificar que los roles esten asignados ROLE_AUDITOR_ADMINISTRATIVO

12. En openkm ejecutar UpdateLiquidador y verificar que los roles esten asignados ROLE_LIQUIDADOR

13. En openkm ejecutar UpdateMedical y verificar que los roles esten asignados ROLE_AUDITOR_MEDICO

14. Revisar que el perfil Administrador tenga todos los roles RS0175

# Crear Liquidadores

1. Hacer los scripts en sql de
    liquidator_audit
    company_liquidator

2. Generar script en sql de social_liquidator cambiando el limite de acuerdo al limite de liquidador 111

3. En openkm ejecutar CreateLiquidator.bsh y cambiar el perfil a razon social cambiar el limite de > 110

4. En openkm ejecutar UpdateLiquidador y verificar que los roles esten asignados ROLE_LIQUIDADOR

5. Cambiar de perfil buscar por correo "Evelinlorena.Gutierrez.Externo@swissmedical.com.ar" al perfil de Liquidador

6. Revisar que el perfil Administrador tenga todos los roles RS0175
